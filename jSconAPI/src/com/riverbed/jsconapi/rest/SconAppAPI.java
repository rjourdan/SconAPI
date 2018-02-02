package com.riverbed.jsconapi.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import com.riverbed.jsconapi.beans.SconAP;
import com.riverbed.jsconapi.beans.SconApp;
import com.riverbed.jsconapi.beans.SconObject;
import com.riverbed.jsconapi.util.StringModifier;

/**
 *  This class provides the primitives to get Applications on SteelConnect. It will make the appropriate REST API calls to a given SCM organization.
 * 
 * SteelConnect does not support Apps creation, Delete or Update. Should you want to do that, you have to use Custom Application
 * 
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
public class SconAppAPI implements SconObjectAPI {

	/**
	 * public constructor for SconAppAPI
	 */
	public SconAppAPI() {
		
	}

	@Override
	/**
	 * This method parses a JsonObject that contains SteelConnect Application details and will build a SconApp object accordingly
	 * @param jsonObj the JsonObject that contains SteelConnect Application details
	 * @return a SconApp object
	 */
	public SconObject convertFromJson(JsonObject jsonObj) {
		SconObject sconObj = null;
		if(jsonObj==null) return null;
				
		JsonValue tempValue;
		String id = jsonObj.getString("id");
		id = StringModifier.removeBrackets(id);
		
		String desc="";
		tempValue = jsonObj.get("desc");
		if(tempValue!=null) desc = tempValue.toString();
		
		String dgrp="";
		tempValue = jsonObj.get("dgrp");
		if(tempValue!=null) dgrp = tempValue.toString();
		
		String name="";
		tempValue = jsonObj.get("name");
		if(tempValue!=null) name = tempValue.toString();
		name = StringModifier.removeBrackets(name);
		
		sconObj = new SconApp(id, desc, dgrp,name);
		return sconObj;
	}

	@Override
	/**
	 * This method creates a JSON object to make REST API calls based on the SconApp object's attributes.
	 * @param obj a SconApp object 
	 * @return a JsonOject built with SconApp Attributes or null if the object was from a different instance.
	 */
	public JsonObject buildSconJsonObject(SconObject obj) {
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		//if object is wrong instance then return null;
		if (!(obj instanceof SconAP)) return json;
		SconApp app = (SconApp)obj;
		
		jsonBuilder
		.add("desc", app.getDesc())
		.add("dgrp", app.getDgrp());
		
		json = jsonBuilder.build();
		
		return json;
	}

	@Override
	/**
	 * Returns a SconApp object based on its name
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param objectName The name of the application we are looking for
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz";
	 * @return a SConApp object that matches objectName or null if not found
	 */
	public SconObject getByName(String realmUrl, String objectName,String orgID) {
		
		//find the object on SteelConnect
		List<SconObject> sconObjectList = getAll(realmUrl, null);
		System.out.println("appName=["+objectName+"]\n");
		//if objectName is sales force, change it to Salesforce
		if(objectName.substring(0, 6).equals("sales ")) objectName="Salesforce";
		
		if(sconObjectList!=null){			
			SconObject obj=null;;
			for (int i=0;i<sconObjectList.size();i++){
				obj = sconObjectList.get(i);
				
				if(obj!=null){
					
					if(objectName.equals(obj.getName())) return obj;	
				}
			}
		}
		return null;
	}
	

	@Override
	/**
	 * Returns a SconApp object based on its ID
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param objId The Id of the application we are looking for
	 * @return a SConApp object that matches objId or null if not found
	 */
	public SconObject get(String realmUrl, String objId) {
		SconApp app = null;
		String url = realmUrl + API_PREFIX+"app/"+objId;
		
		JsonObject jsonObj = null;
		try {
			jsonObj = SconJsonOperations.GetData(url);
			if(jsonObj!=null){
				app = (SconApp) convertFromJson(jsonObj);
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return app;
	}
	
	@Override
	/**
	 * Lists all SconApp objects that it gets from the SteelConnect Organization
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz";
	 * @return a List of all SConApp objects available on the SteelConnect organization
	 */
	public List<SconObject> getAll(String realmUrl, String orgID) {
		List<SconObject> objectList = new ArrayList<SconObject>();
		
		String url = realmUrl + API_PREFIX +"apps";
		JsonObject jsonObj = null;
		try {
			jsonObj = SconJsonOperations.GetData(url);
			if(jsonObj!=null){
				JsonArray array = jsonObj.getJsonArray("items");
				for(int i = 0 ; i < array.size() ; i++){
					objectList.add(convertFromJson(array.getJsonObject(i)));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return objectList;
	}
	

	@Override 
	/**
	 * SteelConnect does not support Application to be created. This method always returns null
	 * @param realmUrl will not be used
	 * @param orgID will not be used
	 * @param obj will not be used
	 * @return null
	 */
	public SconObject create(String realmUrl, String orgID, SconObject obj) {
		return null;
	}

	@Override
	/**
	 * SteelConnect does not support Application to be updated. This method always returns null
	 * @param realmUrl will not be used
	 * @param orgID will not be used
	 * @param obj will not be used
	 * @return null
	 */
	public SconObject update(String realmUrl, String orgID, SconObject obj) {
		return null;
	}

	@Override
	/**
	 * SteelConnect does not support Application to be deleted. This method always returns null
	 * @param realmUrl will not be used
	 * @param orgID will not be used
	 * @param obj will not be used
	 * @return null
	 */
	public SconObject delete(String realmUrl, String orgID, SconObject obj) {
		return null;
	}

	

}
