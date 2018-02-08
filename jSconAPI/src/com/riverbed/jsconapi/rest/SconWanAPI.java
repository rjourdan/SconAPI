package com.riverbed.jsconapi.rest;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;


import com.riverbed.jsconapi.beans.SconObject;
import com.riverbed.jsconapi.beans.SconWan;
import com.riverbed.jsconapi.util.SconUtil;


/**
 * This class provides the primitives to create, update, get or delete WANs on SteelConnect. It will make the appropriate REST API calls to a given SCM organization.
 * 
 * @author rjourdan <a href="mailto:rjourdan@riverbed.com">rjourdan@riverbed.com</a>
 * @version 1.0
 */
public class SconWanAPI implements SconObjectAPI {

	/**
	 * This method parses a JsonObject that contains a SteelConnect WAN details and will build a SconSite object accordingly
	 * @param jsonObj the JsonObject that contains SteelConnect WAN details
	 * @return a SconWAN object
	 */
	public static SconObject convertFromJson(JsonObject jsonObj) {
		SconObject sconObj = null;
		if(jsonObj==null) return null;
				
		JsonValue tempValue;
		String id = jsonObj.getString("id");
		id = SconUtil.removeBrackets(id);
		
		String name = jsonObj.getString("name");
		String[] uplinks = new String[0];
		if(!jsonObj.isNull("uplinks")) uplinks = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("uplinks"));
		
		String[] networks = new String[0];
		if(!jsonObj.isNull("nets"))
		 networks = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("nets"));
		
		String longName="";
		tempValue = jsonObj.get("longname");
		if(tempValue!=null) longName = tempValue.toString();
		
		boolean internet = Boolean.TRUE;
		String test = jsonObj.get("internet").toString();
		if(test.equals("0")) internet = Boolean.FALSE;
	
		boolean sitelink = Boolean.TRUE;
		test = jsonObj.get("sitelink").toString();
		if(test.equals("0")) sitelink = Boolean.FALSE;
		
		boolean breakout = Boolean.TRUE;
		jsonObj.get("breakout").toString();
		if(test.equals("0")) breakout = Boolean.FALSE;
		
		String[] breakout_sites = new String[0];
		if(!jsonObj.isNull("breakout_sites"))
			breakout_sites = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("breakout_sites"));
		
		sconObj = new SconWan(id, name, uplinks, networks, longName, internet, sitelink, breakout, breakout_sites);
		return sconObj;
	}

	/**
	 * This method parses a JsonObject that contains a SteelConnect WAN details and will build a SconWAN object accordingly
	 * @param jsonObj the JsonObject that contains SteelConnect WAN details
	 * @return a SconWAN object
	 */
	public static JsonObject buildSconJsonObject(SconObject obj) {
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		SconWan wan = (SconWan) obj;
		jsonBuilder
			.add("name", wan.getName())
			.add("longname", wan.getLongname())
			.add("breakout", wan.isBreakout())
			.add("sitelink", wan.isSitelink())
			.add("internet", wan.isInternet());
		
		json = jsonBuilder.build();
		
		return json;
	}
	
	/**
	 * Returns a SconWan object based on its ID
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param objId The Id of the site we are looking for
	 * @return a SConWan object that matches objId or null if not found
	 */
	public static SconObject get(String realmUrl, String objId,String orgID) {
		SconWan wan = null;
		
		String url = realmUrl + API_PREFIX+"wan/"+objId;
		
		JsonObject jsonObj = null;
		try {
			jsonObj = SconJsonOperations.GetData(url);
			if(jsonObj!=null){
				wan = (SconWan) convertFromJson(jsonObj);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wan;
	}

	/**
	 * Lists all SconWan that it gets from the SteelConnect Organization
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @return a list of SconWan objects
	 */
	public static List<SconObject> getAll(String realmUrl, String orgID) {
List<SconObject> objectList = new ArrayList<SconObject>();
		
		String url = realmUrl + API_PREFIX +"org/"+orgID+"/wans";
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

	/**
	 * Creates a SconWan in a particular SteelConnect organization via the REST API
	 * @return SconObject the wan that was created
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconWan to be created on SteelConnect
	 */
	public static SconObject create(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX +"org/"+orgID+"/wans";
		
		jsonObj = buildSconJsonObject(obj);
		try {
			jsonObj = SconJsonOperations.PostData(url, jsonObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		JsonValue tempValue = jsonObj.get("id");
		
		if(tempValue!=null){
			String id = SconUtil.removeBrackets(tempValue.toString());
			obj.setId(id);
		}                   
		else return null;
		
		return obj;
	}

	/**
	 * Updates a SconWan in a particular SteelConnect organization via the REST API
	 * @return SconObject the wan that was updated
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconWan to be updated on SteelConnect
	 */
	public static SconObject update(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX+"wan/"+obj.getId();
		
		jsonObj = buildSconJsonObject(obj);
		
		try {
			jsonObj = SconJsonOperations.PutData(url, jsonObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		JsonValue tempValue = jsonObj.get("id");
		if(tempValue!=null){
			String id = SconUtil.removeBrackets(tempValue.toString());
			obj.setId(id);
		}
		                   
		else return null;
		
		return obj;
	}

	/**
	 * Deletes a SconWan in a particular SteelConnect organization via the REST API
	 * @return SconObject the wan that was deleted
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconWan to be deleted on SteelConnect
	 */
	public static SconObject delete(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		String url = realmUrl+API_PREFIX+"wan/"+obj.getId();
		
		
		try {
			SconJsonOperations.DeleteData(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return obj;
	}

}
