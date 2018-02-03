package com.riverbed.jsconapi.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import com.riverbed.jsconapi.beans.SconObject;
import com.riverbed.jsconapi.beans.SconPathRules;
import com.riverbed.jsconapi.util.StringModifier;


/**
 * 
 * This class provides the primitives to create, update, get or delete PathRules on SteelConnect. It will make the appropriate REST API calls to a given SCM organization.
 * 
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
public class SconPathRulesAPI implements SconObjectAPI {

	/**
	 * This method parses a JsonObject that contains SteelConnect Path Rules details and will build a SconPathRules object accordingly
	 * @param jsonObj the JsonObject that contains SteelConnect Path Rules details
	 * @return a SconPathRules object
	 */
	public static SconObject convertFromJson(JsonObject jsonObj) {
		SconObject sconObj = null;
		if(jsonObj==null) return null;
				
		JsonValue tempValue;
		String id = jsonObj.getString("id");
		id = StringModifier.removeBrackets(id);
		
		String uid = jsonObj.getString("uid");
		
		String dsttype="";
		tempValue = jsonObj.get("dsttype");
		if(tempValue!=null) dsttype = tempValue.toString();
		
		String srctype="";
		tempValue = jsonObj.get("srctype");
		if(tempValue!=null) srctype = tempValue.toString();
		
		String qos="";
		tempValue = jsonObj.get("qos");
		if(tempValue!=null) qos = tempValue.toString();
		
		String marking="";
		tempValue = jsonObj.get("marking");
		if(tempValue!=null) marking = tempValue.toString();
		
		String[] zones = new String[0];
		if(!jsonObj.isNull("zones"))
		 zones = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("zones"));
		
		String[] sites = new String[0];
		if(!jsonObj.isNull("sites"))
		 sites = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("sites"));
		
		String[] path_preference = new String[0];
		if(!jsonObj.isNull("path_preference"))
			path_preference = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("path_preference"));
		
		boolean active = false;
		String activeString = jsonObj.get("active").toString();
		if(activeString.equals("1")) active = true;
		
		String dscp="";
		tempValue = jsonObj.get("dcsp");
		if(tempValue!=null) dscp = tempValue.toString();
		
		String[] apps = new String[0];
		if(!jsonObj.isNull("apps"))
		 apps = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("apps"));
		
		String[] devices = new String[0];
		if(!jsonObj.isNull("devices"))
			devices = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("devices"));
		
		String tags="";
		tempValue = jsonObj.get("tags");
		if(tempValue!=null) tags = tempValue.toString();
		
		String[] users = new String[0];
		if(!jsonObj.isNull("users"))
			users = SconObjectCallApi.jsonArrayToStringArray(jsonObj.getJsonArray("users"));

		String sapps="";
		tempValue = jsonObj.get("sapps");
		if(tempValue!=null) sapps = tempValue.toString();
		
		sconObj = new SconPathRules(id, dsttype, srctype, qos, marking, zones, uid, sites, path_preference, active, dscp, apps, devices, tags, users,sapps);
		return sconObj;
	}

	

	/**
	 * This method creates a JSON object to make REST API calls based on the SconPathRules object's attributes.
	 * @param obj a SconPathRules object 
	 * @return a JsonOject built with SconPathRules Attributes or null if the object was from a different instance.
	 */
	public static JsonObject buildSconJsonObject(SconObject obj) {
		JsonObject json = null;
		//if object is wrong instance then return null;
		if (!(obj instanceof SconPathRules)) return json;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		SconPathRules pathRule = (SconPathRules) obj;
		
		JsonArrayBuilder zonesBuilder = Json.createArrayBuilder();
		if(pathRule.getZones()!=null){
			for (String zone : pathRule.getZones()){
				zonesBuilder.add(zone);
			}
		}
			
		JsonArrayBuilder sitesBuilder = Json.createArrayBuilder();
		if(pathRule.getSites()!=null){
			for (String site : pathRule.getSites()){
				if(site!=null) sitesBuilder.add(site);
			}
		}
		
		JsonArrayBuilder pathPreferenceBuilder = Json.createArrayBuilder();
		if(pathRule.getPath_preference()!=null){
			for (String path : pathRule.getPath_preference()){
				if(path!=null) pathPreferenceBuilder.add(path);
			}
		}
		
		JsonArrayBuilder appsBuilder = Json.createArrayBuilder();
		if(pathRule.getApps()!=null){
			for (String app : pathRule.getApps()){
				if(app!=null) appsBuilder.add(app);
			}
		}
		
		JsonArrayBuilder devicesBuilder = Json.createArrayBuilder();
		if(pathRule.getDevices()!=null){
			for (String device : pathRule.getDevices()){
				if(device!=null) devicesBuilder.add(device);
			}
		}
		
		JsonArrayBuilder usersBuilder = Json.createArrayBuilder();
		if(pathRule.getUsers()!=null){
			for (String user : pathRule.getUsers()){
				if(user!=null) usersBuilder.add(user);
			}
		}
		
		String active = "0";
		if(pathRule.isActive()) active = "1";
		
		jsonBuilder
		.add("path_preference", pathPreferenceBuilder)
		.add("dsttype",pathRule.getDsttype())
		.add("srctype", pathRule.getSrctype())
		.add("qos",pathRule.getQos())
		.add("marking", pathRule.getMarking())
		.add("zones", zonesBuilder)
		.add("active", active)
		.add("sites", sitesBuilder)
		.add("apps", appsBuilder)
		.add("dscp", pathRule.getDscp())
		.add("devices", devicesBuilder)
		.add("tags", pathRule.getTags())
		.add("sapps", pathRule.getSapps())
		.add("users", usersBuilder);
		
		json = jsonBuilder.build();
		
		return json;
	}

	
	/**
	 * Returns a SconPathRules object based on its ID
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param objId The Id of the application we are looking for
	 * @return a SconPathRules object that matches objId or null if not found
	 */
	public static SconObject get(String realmUrl, String objId) {
		SconPathRules rule = null;
		String url = realmUrl + API_PREFIX+"path_rule/"+objId;
		
		JsonObject jsonObj = null;
		try {
			jsonObj = SconJsonOperations.GetData(url);
			if(jsonObj!=null){
				rule = (SconPathRules) convertFromJson(jsonObj);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rule;
	}

	
	/**
	 * Lists all SconPathRules that it gets from the SteelConnect Organization
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param objectName The name of the path rule we are looking for
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz";
	 * @return a list of all SConPathRule objects from the org
	 */
	
	public static List<SconObject> getAll(String realmUrl, String orgID) {
		List<SconObject> objectList = new ArrayList<SconObject>();
		
		String url = realmUrl + API_PREFIX +"path_rules";
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
	 * Creates a Path Rule in a particular SteelConnect organization via the REST API
	 * @return SconPathRules the object that was created
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconPathRules to be created on SteelConnect
	 */
	public static SconObject create(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX +"org/"+orgID+"/path_rules";
		
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

	
	/**
	 * Updates a Path Rule in a particular SteelConnect organization via the REST API
	 * @return SconPathRules the object that was updated
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconPathRules to be updated on SteelConnect
	 */
	public static SconObject update(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX+"path_rule/"+obj.getId();
		
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
		} else return null;
		
		return obj;
	}


	/**
	 * Deletes a Path Rule in a particular SteelConnect organization via the REST API
	 * @return SconPathRules the object that was deleted
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconPathRules to be deleted on SteelConnect
	 */
	public static SconObject delete(String realmUrl, String orgID, SconObject obj) {
		
		if(obj==null) return null;
		
		String url = realmUrl+API_PREFIX+"path_rule/"+obj.getId();
		
		
		try {
			SconJsonOperations.DeleteData(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return obj;
	}

	

}
