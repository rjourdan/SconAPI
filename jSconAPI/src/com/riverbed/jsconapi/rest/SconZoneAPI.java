/**
 * 
 */
package com.riverbed.jsconapi.rest;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;


import com.riverbed.jsconapi.beans.SconOSPF;
import com.riverbed.jsconapi.beans.SconObject;
import com.riverbed.jsconapi.beans.SconUplink;
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
		if(tempValue!=null) ospf.setDead_interval(Integer.parseInt(tempValue.toString()));
		
		tempValue = jsonObj.get("hello_interval");
		if(tempValue!=null) ospf.setHello_interval(Integer.parseInt(tempValue.toString()));
		
		tempValue = jsonObj.get("area");
		if(tempValue!=null) ospf.setArea(Integer.parseInt(tempValue.toString()));
		
		tempValue = jsonObj.get("cost");
		if(tempValue!=null) ospf.setCost(Integer.parseInt(tempValue.toString()));

		tempValue = jsonObj.get("password");
		if(tempValue!=null) ospf.setPassword(tempValue.toString());

		String testInherit = jsonObj.get("inherit").toString();
		if(testInherit.equals("1")) ospf.setInherit(Boolean.TRUE);
		
		tempValue = jsonObj.get("priority");
		if(tempValue!=null) ospf.setPriority(Integer.parseInt(tempValue.toString()));
		
		
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
				if (!(obj instanceof SconUplink)) return json;
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
		
		jsonBuilder
		.add("dead_interval", ospfConfig.getDead_interval())
		.add("name", zone.getName())
		.add("networks",netsBuilder)
		.add("site",zone.getSiteID())
		.add("mgmt", zone.getMgmt())
		.add("hello_interval", ospfConfig.getHello_interval())
		.add("area",ospfConfig.getArea())
		.add("tag", zone.getTag())
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
		
		json = jsonBuilder.build();
		
		return json;
	}

}
