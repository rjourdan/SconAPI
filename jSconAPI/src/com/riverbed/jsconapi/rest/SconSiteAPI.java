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
import com.riverbed.jsconapi.beans.SconSite;
import com.riverbed.jsconapi.util.StringModifier;

/**
 * This class provides the primitives to create, update, get or delete Sites on SteelConnect. It will make the appropriate REST API calls to a given SCM organization.
 * 
 * @author rjourdan <a href="mailto:rjourdan@riverbed.com">rjourdan@riverbed.com</a>
 * @version 1.0
 */
public class SconSiteAPI implements SconObjectAPI {

	public SconSiteAPI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SconObject convertFromJson(JsonObject jsonObj) {
		SconObject sconObj = null;
		if(jsonObj==null) return null;
				
		JsonValue tempValue;
		String id = jsonObj.getString("id");
		id = StringModifier.removeBrackets(id);
		
		String name = jsonObj.getString("name");
		
		String longName="";
		tempValue = jsonObj.get("longname");
		if(tempValue!=null) longName = tempValue.toString();
		
		String address = "";
		tempValue = jsonObj.get("street_address");
		if(!jsonObj.isNull("street_address")) address = jsonObj.getString("street_address");
		String city = jsonObj.getString("city");
		String countryCode = jsonObj.getString("country");
		
		String[] uplinks = new String[0];
		if(!jsonObj.isNull("uplinks")) uplinks = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("uplinks"));
		
		String timezone = jsonObj.getString("timezone");
		
		String[] networks = new String[0];
		if(!jsonObj.isNull("networks"))
		 networks = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("networks"));
		
		int size = 0;
		if(!jsonObj.isNull("size")) size = Integer.parseInt(jsonObj.getString("size"));
		sconObj = new SconSite(id, name, longName, address, city, countryCode, uplinks, timezone, networks, size);
		return sconObj;
	}

	@Override
	public JsonObject buildSconJsonObject(SconObject obj) {
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		SconSite site = (SconSite) obj;
		jsonBuilder
			.add("name", site.getName())
			.add("longname", site.getLongName())
			.add("street_address",site.getAddress())
			.add("city", site.getCity())
			.add("country", site.getCountryCode());
		json = jsonBuilder.build();
		
		return json;
	}

	@Override
	public SconObject getByName(String realmUrl, String objectName, String orgID) {
		//find the object on SteelConnect
		List<SconObject> sconObjectList = getAll(realmUrl, orgID);
		
		if(sconObjectList!=null){			
			SconObject obj=null;
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
	public SconObject get(String realmUrl, String objId) {
		SconSite site = null;
		
		String url = realmUrl + API_PREFIX+"site/"+objId;
		
		JsonObject jsonObj = null;
		try {
			jsonObj = SconJsonOperations.GetData(url);
			if(jsonObj!=null){
				site = (SconSite) convertFromJson(jsonObj);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return site;
		
	}

	@Override
	public List<SconObject> getAll(String realmUrl, String orgID) {
		List<SconObject> objectList = new ArrayList<SconObject>();
		
		String url = realmUrl + API_PREFIX +"org/"+orgID+"/sites";
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
	public SconObject create(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX +"org/"+orgID+"/sites";
		
		jsonObj = buildSconJsonObject(obj);
		try {
			jsonObj = SconJsonOperations.PostData(url, jsonObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		JsonValue tempValue = jsonObj.get("id");
		
		if(tempValue!=null){
			String id = StringModifier.removeBrackets(tempValue.toString());
			obj.setId(id);
		}                   
		else return null;
		
		return obj;
	}

	@Override
	public SconObject update(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX+"site/"+obj.getId();
		
		jsonObj = buildSconJsonObject(obj);
		
		try {
			jsonObj = SconJsonOperations.PutData(url, jsonObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		JsonValue tempValue = jsonObj.get("id");
		if(tempValue!=null){
			String id = StringModifier.removeBrackets(tempValue.toString());
			obj.setId(id);
		}
		                   
		else return null;
		
		return obj;
	}

	@Override
	public SconObject delete(String realmUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
