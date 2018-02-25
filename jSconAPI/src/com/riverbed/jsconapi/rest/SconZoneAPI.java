/**
 * 
 */
package com.riverbed.jsconapi.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;


import com.riverbed.jsconapi.beans.SconOSPF;
import com.riverbed.jsconapi.beans.SconObject;
import com.riverbed.jsconapi.beans.SconZone;
import com.riverbed.jsconapi.util.SconUtil;

/**
 * This class provides the primitives to create, update, get or delete Zones on SteelConnect. It will make the appropriate REST API calls to a given SCM organization.
 * 
 * @author rjourdan <a href="mailto:rjourdan@riverbed.com">rjourdan@riverbed.com</a>
 * @version 1.0
 */
public class SconZoneAPI implements SconObjectAPI {

	/**
	 * This method parses a JsonObject that contains SteelConnect Zone details and will build a SconZone object accordingly
	 * @param jsonObj the JsonObject that contains SteelConnect Zone details
	 * @return a SconZone object
	 */
	public static SconObject convertFromJson(JsonObject jsonObj) {
		SconObject sconObj = null;
		String tempString = null;
		if(jsonObj==null) return null;
		
		
		JsonValue tempValue;
		String name="";
		tempValue = jsonObj.get("name");
		if(tempValue!=null) name = tempValue.toString();
		name = SconUtil.removeBrackets(name);
		
		String id = jsonObj.getString("id");
		id = SconUtil.removeBrackets(id);
		
		String siteID = jsonObj.getString("site");
		
		String[] networks = new String[0];
		if(!jsonObj.isNull("networks"))
		 networks = SconUtil.jsonArrayToStringArray(jsonObj.getJsonArray("networks"));
		
		String mgmt="";
		tempValue = jsonObj.get("mgmt");
		if(tempValue!=null) mgmt = tempValue.toString();
		
		String icmp="";
		tempValue = jsonObj.get("icmp");
		if(tempValue!=null) icmp = tempValue.toString();
		
		String guest="";
		tempValue = jsonObj.get("guest");
		if(tempValue!=null) guest = tempValue.toString();
		
		String[] breakoutPreference = new String[0];
		if(!jsonObj.isNull("breakout_preference"))
			breakoutPreference = SconUtil.jsonArrayToStringArray(jsonObj.getJsonArray("breakout_preference"));
		
		String[] routes = new String[0];
		if(!jsonObj.isNull("routes"))
		 routes = SconUtil.jsonArrayToStringArray(jsonObj.getJsonArray("routes"));
		
		String[] bcasts = new String[0];
		if(!jsonObj.isNull("bcasts"))
			bcasts = SconUtil.jsonArrayToStringArray(jsonObj.getJsonArray("bcasts"));
		
		String tag="";
		tempValue = jsonObj.get("tag");
		if(tempValue!=null) tag = tempValue.toString();
		
		String tags="";
		tempValue = jsonObj.get("tags");
		if(tempValue!=null) tags = tempValue.toString();
		
		//OSPF parameters
		SconOSPF ospf = new SconOSPF();
	
		tempValue = jsonObj.get("dead_interval");
		if(tempValue!=null) {
			tempString = tempValue.toString();
			tempString = SconUtil.removeBrackets(tempString);
			if (!tempString.equals("null")) ospf.setDead_interval(Integer.parseInt(tempString));
		}
		
		tempValue = jsonObj.get("hello_interval");
		if(tempValue!=null) {
			tempString = tempValue.toString();
			tempString = SconUtil.removeBrackets(tempString);
			if (!tempString.equals("null"))  ospf.setHello_interval(Integer.parseInt(tempString));
		}
		
		tempValue = jsonObj.get("area");
		if(tempValue!=null) {
			tempString = tempValue.toString();
			tempString = SconUtil.removeBrackets(tempString);
			if (!tempString.equals("null"))  ospf.setArea(Integer.parseInt(tempString));
		}
		
		tempValue = jsonObj.get("cost");
		if(tempValue!=null) {
			tempString = tempValue.toString();
			tempString = SconUtil.removeBrackets(tempString);
			if (!tempString.equals("null")) ospf.setCost(Integer.parseInt(tempString));
		}

		tempValue = jsonObj.get("password");
		if(tempValue!=null) ospf.setPassword(tempValue.toString());

		String testInherit = jsonObj.get("inherit").toString();
		if(testInherit.equals("1")) ospf.setInherit(Boolean.TRUE);
		
		tempValue = jsonObj.get("priority");
		if(tempValue!=null)  {
			tempString = tempValue.toString();
			tempString = SconUtil.removeBrackets(tempString);
			if (!tempString.equals("null")) ospf.setPriority(Integer.parseInt(tempString));
		}
		
		
		sconObj = new SconZone(id, name, siteID, networks, mgmt, icmp, guest, breakoutPreference, routes, bcasts, tag, tags,ospf);
		
		return sconObj;
	}
	
	
	/**
	 * This method creates a JSON object to make REST API calls based on the SconZone object's attributes.
	 * @param obj a SconZone object 
	 * @return a JsonOject built with SconZone Attributes or null if the object was from a different instance.
	 */
	public static JsonObject buildSconJsonObject(SconObject obj) {
		JsonObject json = null;
		//if object is wrong instance then return null;
				if (!(obj instanceof SconZone)) return json;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		
		SconZone zone = (SconZone)obj;
		SconOSPF ospfConfig = zone.getOspfConfig();
		
		JsonArrayBuilder netsBuilder = Json.createArrayBuilder();
		if(zone.getNetworks()!=null){
			for (String network : zone.getNetworks()){
				if(network!=null) netsBuilder.add(network);
			}
		}
		
		JsonArrayBuilder broadcastBuilder = Json.createArrayBuilder();
		if(zone.getBcasts()!=null){
			for (String broadcast : zone.getBcasts()){
				if(broadcast!=null) broadcastBuilder.add(broadcast);
			}
		}
		
		JsonArrayBuilder routesBuilder = Json.createArrayBuilder();
		if(zone.getRoutes()!=null){
			for (String route : zone.getRoutes()){
				if(route!=null) routesBuilder.add(route);
			}
		}
		
		JsonArrayBuilder bpBuilder = Json.createArrayBuilder();
		if(zone.getBreakoutPreference()!=null){
			for (String bp : zone.getBreakoutPreference()){
				if(bp!=null) bpBuilder.add(bp);
			}
		}
		
		String name = zone.getName();
		if(name.length()<0) name = "zoneName"+SconUtil.generateString(new Random(), "012345678QWERTZUIOOPASDJLKYCVVB,", 5);
		else name = SconUtil.replaceSpaceByUnderscore(name);
		
		jsonBuilder
		.add("dead_interval", ospfConfig.getDead_interval())
		.add("name", name)
		.add("networks",netsBuilder)
		.add("site",zone.getSiteID())
		.add("mgmt", zone.getMgmt())
		.add("hello_interval", ospfConfig.getHello_interval())
		.add("area",ospfConfig.getArea())
		.add("cost", ospfConfig.getCost())
		.add("guest",zone.getGuest())
		.add("password", ospfConfig.getPassword())
		.add("bcasts", broadcastBuilder)
		.add("icmp",zone.getIcmp())
		.add("inherit", ospfConfig.isInherit())
		.add("priority", ospfConfig.getPriority())
		.add("routes", routesBuilder)
		.add("breakout_preference", bpBuilder)
		.add("tags", zone.getTags());
		
		if(zone.getTag()!=null) jsonBuilder.add("tag", zone.getTag());
		
		json = jsonBuilder.build();
		
		return json;
	}

	/**
	 * Returns a SconZone object based on its ID
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param objId The Id of the site we are looking for
	 * @return a SConZone object that matches objId or null if not found
	 */
	public static SconObject get(String realmUrl, String objId,String orgID) {
		SconZone zone = null;
		
		String url = realmUrl + API_PREFIX+"zone/"+objId;
		
		JsonObject jsonObj = null;
		try {
			jsonObj = SconRESTOperations.GetData(url);
			if(jsonObj!=null){
				zone = (SconZone) convertFromJson(jsonObj);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return zone;
	}

	/**
	 * Lists all SconZone that it gets from the SteelConnect Organization
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @return a list of SconZone objects
	 */
	public static List<SconObject> getAll(String realmUrl, String orgID) {
		List<SconObject> objectList = new ArrayList<SconObject>();
		
		String url = realmUrl + API_PREFIX +"org/"+orgID+"/zones";
		JsonObject jsonObj = null;
		try {
			jsonObj = SconRESTOperations.GetData(url);
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
	 * Creates a SconZone in a particular SteelConnect organization via the REST API
	 * @return SconObject the Zone that was created
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconZon to be created on SteelConnect
	 */
	public static SconObject create(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX +"org/"+orgID+"/zones";
		
		jsonObj = buildSconJsonObject(obj);
		try {
			jsonObj = SconRESTOperations.PostData(url, jsonObj);
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
	 * Updates a SconZone in a particular SteelConnect organization via the REST API
	 * @return SconObject the zone that was updated
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconZone to be updated on SteelConnect
	 */
	public static SconObject update(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX+"zone/"+obj.getId();
		
		jsonObj = buildSconJsonObject(obj);
		
		try {
			jsonObj = SconRESTOperations.PutData(url, jsonObj);
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
	 * Deletes a SconZone in a particular SteelConnect organization via the REST API
	 * @return SconObject the zone that was deleted
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconZone to be deleted on SteelConnect
	 */
	public static SconObject delete(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		String url = realmUrl+API_PREFIX+"zone/"+obj.getId();
		
		
		try {
			SconRESTOperations.DeleteData(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return obj;
	}

	
}
