/**
 * This class provides the primitives to create, update, get or delete Uplinks on SteelConnect. It will make the appropriate REST API calls to a given SCM organization.
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */

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
import com.riverbed.jsconapi.beans.SconUplink;
import com.riverbed.jsconapi.util.StringModifier;


public class SconUplinkAPI implements SconObjectAPI {
	
	/**
	 * This method parses a JsonObject that contains a SteelConnect Uplink details and will build a SconUplink object accordingly
	 * @param jsonObj the JsonObject that contains SteelConnect uplink details
	 * @return a SconUplink object
	 */
	public static SconObject convertFromJson(JsonObject jsonObj) {
		SconObject sconObj = null;
		if(jsonObj==null) return null;
				
		JsonValue tempValue;
		String id = jsonObj.getString("id");
		id = StringModifier.removeBrackets(id);
		
		String name = jsonObj.getString("name");
		
		int qos_bw_up = 0;
		tempValue = jsonObj.get("qos_bw_up");
		//if(tempValue!=null) qos_bw_up = Integer.parseInt(tempValue.toString().substring(1, tempValue.toString().length()-1));
		if(tempValue!=null) qos_bw_up = Integer.parseInt(tempValue.toString());
		
		int qos_up= 0;
		tempValue = jsonObj.get("qos_up");
		//if(tempValue!=null) qos_up = Integer.parseInt(tempValue.toString().substring(1, tempValue.toString().length()-1));
		if(tempValue!=null) qos_up = Integer.parseInt(tempValue.toString());
		
		int qos_bw_down= 0;
		tempValue = jsonObj.get("qos_bw_down");
		//if(tempValue!=null) qos_bw_down = Integer.parseInt(tempValue.toString().substring(1, tempValue.toString().length()-1));
		if(tempValue!=null) qos_bw_down = Integer.parseInt(tempValue.toString());
		
		int qos_down= 0;
		tempValue = jsonObj.get("qos_down");
		//if(tempValue!=null) qos_down = Integer.parseInt(tempValue.toString().substring(1, tempValue.toString().length()-1));
		if(tempValue!=null) qos_down = Integer.parseInt(tempValue.toString());
		
		String site = jsonObj.getString("site");
		
		String static_gw_v6="";
		tempValue = jsonObj.get("static_gw_v6");
		if(tempValue!=null) static_gw_v6 = tempValue.toString();
		
		String static_ip_v6="";
		tempValue = jsonObj.get("static_ip_v6");
		if(tempValue!=null) static_ip_v6 = tempValue.toString();
		
		String static_gw_v4="";
		tempValue = jsonObj.get("static_gw_v4");
		if(tempValue!=null) static_gw_v4 = tempValue.toString();
		
		String static_ip_v4="";
		tempValue = jsonObj.get("static_ip_v4");
		if(tempValue!=null) static_ip_v4 = tempValue.toString();
		
		String node ="";
		tempValue = jsonObj.get("node");
		if(tempValue!=null) node = tempValue.toString();
		
		String wan = "";
		tempValue = jsonObj.get("wan");
		if(tempValue!=null) wan = tempValue.toString();

		String port="";
		tempValue = jsonObj.get("port");
		if(tempValue!=null) port = tempValue.toString();
		
		int vlan=0;
		tempValue = jsonObj.get("vlan");
		if(!jsonObj.isNull("vlan")) vlan = Integer.parseInt(tempValue.toString());
		
		String uplinkType = "";
		uplinkType = jsonObj.get("type").toString();
		
		boolean auto_negotiation = Boolean.TRUE;
		String test = jsonObj.get("auto_negotiation").toString();
		if(test.equals("0")) auto_negotiation = Boolean.FALSE;
		
		int linkSpeed = 0;
		tempValue = jsonObj.get("link_speed");
		if(!jsonObj.isNull("link_speed")) linkSpeed = Integer.parseInt(tempValue.toString());
		
		sconObj = new SconUplink(id,name,qos_bw_up, qos_up, qos_bw_down, qos_down, site, static_gw_v6,static_ip_v6, static_gw_v4, static_ip_v4, node, wan, port,vlan, uplinkType, auto_negotiation, linkSpeed); 
				
		return sconObj;
	}

	/**
	 * This method creates a JSON object to make REST API calls based on the SconUplink object's attributes.
	 * @param obj a SconUplink object 
	 * @return a JsonOject built with SconUplink Attributes or null if the object was from a different instance.
	 */
	public static JsonObject buildSconJsonObject(SconObject obj) {
		JsonObject json = null;
		//if object is wrong instance then return null;
				if (!(obj instanceof SconUplink)) return json;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		
		SconUplink uplink = (SconUplink) obj;
		jsonBuilder
		.add("name", uplink.getName())
		.add("site",uplink.getSite())
		.add("wan",uplink.getWan())
		.add("type", uplink.getType())
		.add("static_ip_v4", uplink.getStatic_ip_v4())
		.add("static_gw_v4", uplink.getStatic_gw_v4())
		.add("static_ip_v6", uplink.getStatic_ip_v6())
		.add("static_gw_v6", uplink.getStatic_gw_v6())
		.add("link_speed",uplink.getLink_speed())
		.add("auto_negotiation", uplink.isAuto_negotiation());
		
		json = jsonBuilder.build();
		
		return json;
	}


	/**
	 * Returns a SconUplink object based on its ID
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param objId The Id of the uplink we are looking for
	 * @return a SConUplink object that matches objId or null if not found
	 */
	public static SconObject get(String realmUrl, String objId) {
		SconUplink uplink = null;
		
		String url = realmUrl + API_PREFIX+"uplink/"+objId;
		
		JsonObject jsonObj = null;
		try {
			jsonObj = SconJsonOperations.GetData(url);
			if(jsonObj!=null){
				uplink = (SconUplink) convertFromJson(jsonObj);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return uplink;
	}

	/**
	 * Lists all SconUplinks that it gets from the SteelConnect Organization
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @return a list of SconUplink objects
	 */
	public static List<SconObject> getAll(String realmUrl, String orgID) {
		List<SconObject> objectList = new ArrayList<SconObject>();
		
		String url = realmUrl + API_PREFIX +"org/"+orgID+"/uplinks";
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
	 * Creates a SconUplink in a particular SteelConnect organization via the REST API
	 * @return SconObject the uplink that was created
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconUplink to be created on SteelConnect
	 */
	public static SconObject create(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX +"org/"+orgID+"/uplinks";
		
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
	 * Updates a SconUplink in a particular SteelConnect organization via the REST API
	 * @return SconObject the uplink that was updated
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconUplink to be updated on SteelConnect
	 */
	public static SconObject update(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX+"uplink/"+obj.getId();
		
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

	/**
	 * Deletes a SconUplink in a particular SteelConnect organization via the REST API
	 * @return SconObject the uplink that was deleted
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconUplink to be deleted on SteelConnect
	 */
	public static SconObject delete(String realmUrl, String orgID, SconObject obj) {
	if(obj==null) return null;
		
		String url = realmUrl+API_PREFIX+"uplink/"+obj.getId();
		
		
		try {
			SconJsonOperations.DeleteData(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return obj;
	}
}
