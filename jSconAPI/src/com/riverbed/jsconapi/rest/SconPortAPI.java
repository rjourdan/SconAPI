/**
 * 
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
import com.riverbed.jsconapi.beans.SconPort;
import com.riverbed.jsconapi.util.SconUtil;

/**
 * This class provides the primitives to create, update, get or delete Ports on SteelConnect. It will make the appropriate REST API calls to a given SCM organization.
 * 
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
public class SconPortAPI implements SconObjectAPI {
	/**
	 * This method parses a JsonObject that contains SteelConnect Port details and will build a SconPort object accordingly
	 * @param jsonObj the JsonObject that contains SteelConnect Port details
	 * @return a SconPort object
	 */
	public static SconObject convertFromJson(JsonObject jsonObj) {
		SconPort port = new SconPort();
		
		if(jsonObj==null) return null;
		
		
		JsonValue tempValue;
		String name="";
		tempValue = jsonObj.get("name");
		if(tempValue!=null) name = tempValue.toString();
		name = SconUtil.removeBrackets(name);
		port.setName(name);
		
		String id = jsonObj.getString("id");
		id = SconUtil.removeBrackets(id);
		port.setId(id);
		
		String portId = "";
		tempValue = jsonObj.get("port_id");
		if(!jsonObj.isNull("port_id")) portId = jsonObj.getString("port_id");
		port.setPortId(portId);
		
		String node = "";
		tempValue = jsonObj.get("node");
		if(!jsonObj.isNull("node")) node = jsonObj.getString("node");	
		port.setNode(node);
		
		String typePort = "";
		tempValue = jsonObj.get("type");
		if(!jsonObj.isNull("type")) typePort = jsonObj.getString("type");
		port.setType(typePort);
		
		String mac = "";
		tempValue = jsonObj.get("mac");
		if(!jsonObj.isNull("mac")) mac = jsonObj.getString("mac");
		port.setMac(mac);
		
		String switchId = "";
		tempValue = jsonObj.get("switch_id");
		if(!jsonObj.isNull("switch_id")) switchId = jsonObj.getString("switch_id");
		port.setSwitchId(switchId);
		
		 String tag="";
		 tempValue = jsonObj.get("tag");
		 if(!jsonObj.isNull("tag")) tag = jsonObj.getString("tag");	
		 port.setTag(tag);
		 
		 String speeds="";
		 tempValue = jsonObj.get("speeds");
		 if(!jsonObj.isNull("speeds")) speeds = jsonObj.getString("speeds");
		 port.setSpeeds(speeds);
		 
		 String speed="";
		 tempValue = jsonObj.get("speed");
		 if(!jsonObj.isNull("speed")) speed = jsonObj.getString("speed");
		 port.setSpeed(speed);
		 
		 
		 
		  String patchlabel="";
		  tempValue = jsonObj.get("patchlabel");
		  if(!jsonObj.isNull("patchlabel")) patchlabel = jsonObj.getString("patchlabel");
		  port.setPatchlabel(patchlabel);
		  
		  String segment="";
		  tempValue = jsonObj.get("segment");
		  if(!jsonObj.isNull("segment")) segment = jsonObj.getString("segment");
		  port.setSegment(segment);
		  
		  String uplink="";
		  tempValue = jsonObj.get("uplink");
		  if(!jsonObj.isNull("uplink")) uplink = jsonObj.getString("uplink");
		  port.setUplink(uplink);
		  
		  String portal="";
		  tempValue = jsonObj.get("portal");
		  if(!jsonObj.isNull("portal")) uplink = jsonObj.getString("portal");
		  port.setPortal(portal);
		  
		  
		  String virtualMac="";
		  tempValue = jsonObj.get("virtual_mac");
		  if(!jsonObj.isNull("virtual_mac")) virtualMac = jsonObj.getString("virtual_mac");
		  port.setVirtualMac(virtualMac);
		  
		  String mgmt_config_type="";
		  tempValue = jsonObj.get("mgmt_config_type");
		  if(!jsonObj.isNull("mgmt_config_type")) mgmt_config_type = jsonObj.getString("mgmt_config_type");
		  port.setMgmt_config_type(mgmt_config_type);
		  
		  String mgmt_ipv4="";
		  tempValue = jsonObj.get("mgmt_ipv4");
		  if(!jsonObj.isNull("mgmt_ipv4")) mgmt_ipv4 = jsonObj.getString("mgmt_ipv4");
		  port.setMgmt_ipv4(mgmt_ipv4);
		  
		  String mgmt_gw_ipv4="";
		  tempValue = jsonObj.get("mgmt_gw_ipv4");
		  if(!jsonObj.isNull("mgmt_gw_ipv4")) mgmt_gw_ipv4 = jsonObj.getString("mgmt_gw_ipv4");
		  port.setMgmt_gw_ipv4(mgmt_gw_ipv4);
		  
		  String mgmt_ipv6="";
		  tempValue = jsonObj.get("mgmt_ipv6");
		  if(!jsonObj.isNull("mgmt_ipv6")) mgmt_ipv6 = jsonObj.getString("mgmt_ipv6");
		  port.setMgmt_ipv6(mgmt_ipv6);
		  
		  String mgmt_gw_ipv6="";
		  tempValue = jsonObj.get("mgmt_gw_ipv6");
		  if(!jsonObj.isNull("mgmt_gw_ipv6")) mgmt_gw_ipv6 = jsonObj.getString("mgmt_gw_ipv6");
		  port.setMgmt_gw_ipv6(mgmt_gw_ipv6);
		  
		  String mgmt_dns_ipv4="";
		  tempValue = jsonObj.get("mgmt_dns_ipv4");
		  if(!jsonObj.isNull("mgmt_dns_ipv4")) mgmt_dns_ipv4 = jsonObj.getString("mgmt_dns_ipv4");
		  port.setMgmt_dns_ipv4(mgmt_dns_ipv4);
		  
		  String bridge_with="";
		  tempValue = jsonObj.get("bridge_with");
		  if(!jsonObj.isNull("bridge_with")) bridge_with = jsonObj.getString("bridge_with");
		  port.setBridge_with(bridge_with);
		  
		  String ifname="";
		  tempValue = jsonObj.get("ifname");
		  if(!jsonObj.isNull("ifname")) ifname = jsonObj.getString("ifname");
		  port.setIfname(ifname);
		  
		  String dcinterface="";
		  tempValue = jsonObj.get("dcinterface");
		  if(!jsonObj.isNull("dcinterface")) dcinterface = jsonObj.getString("dcinterface");
		  port.setDcinterface(dcinterface);
	
		  String test = jsonObj.get("autotrunk").toString();
		  if(test.equals("0")) port.setAutotrunk(Boolean.FALSE);
		  else port.setAutotrunk(Boolean.TRUE);
		 
		  test = jsonObj.get("auto").toString();
		  if(test.equals("0")) port.setAuto(Boolean.FALSE);
		  else port.setAuto(Boolean.TRUE);
		  
		  test = jsonObj.get("autocfg").toString();
		  if(test.equals("0")) port.setAutocfg(Boolean.FALSE);
		  else port.setAutocfg(Boolean.TRUE);
		  
		  test = jsonObj.get("tagged").toString();
		  if(test.equals("0")) port.setTagged(Boolean.FALSE);
		  else port.setTagged(Boolean.TRUE);
		  

		  test = jsonObj.get("vsh_aux_enabled").toString();
		  if(test.equals("0")) port.setVsh_aux_enabled(Boolean.FALSE);
		  else port.setVsh_aux_enabled(Boolean.TRUE);
		  
		  test = jsonObj.get("vsh_primary_enabled").toString();
		  if(test.equals("0")) port.setVsh_primary_enabled(Boolean.FALSE);
		  else port.setVsh_primary_enabled(Boolean.TRUE);
		  
		  test = jsonObj.get("cluster_enabled").toString();
		  if(test.equals("0")) port.setCluster_enabled(Boolean.FALSE);
		  else port.setCluster_enabled(Boolean.TRUE);
		  
		  test = jsonObj.get("data_enabled").toString();
		  if(test.equals("0")) port.setData_enabled(Boolean.FALSE);
		  else port.setData_enabled(Boolean.TRUE);
		  
		  test = jsonObj.get("mgmt_enabled").toString();
		  if(test.equals("0")) port.setMgmt_enabled(Boolean.FALSE);
		  else port.setMgmt_enabled(Boolean.TRUE);
		  
		  test = jsonObj.get("poe_disabled").toString();
		  if(test.equals("0")) port.setPoe_disabled(Boolean.FALSE);
		  else port.setPoe_disabled(Boolean.TRUE);
		  
		  test = jsonObj.get("capab_multizone").toString();
		  if(test.equals("0")) port.setCapab_multizone(Boolean.FALSE);
		  else port.setCapab_multizone(Boolean.TRUE);
		  
		  test = jsonObj.get("capab_vsh_aux").toString();
		  if(test.equals("0")) port.setCapab_vsh_aux(Boolean.FALSE);
		  else port.setCapab_vsh_aux(Boolean.TRUE);
		  
		  test = jsonObj.get("capab_mgmt").toString();
		  if(test.equals("0")) port.setCapab_mgmt(Boolean.FALSE);
		  else port.setCapab_mgmt(Boolean.TRUE);
		  
		  test = jsonObj.get("capab_lan").toString();
		  if(test.equals("0")) port.setCapab_lan(Boolean.FALSE);
		  else port.setCapab_lan(Boolean.TRUE);
		  
		  test = jsonObj.get("capab_poe").toString();
		  if(test.equals("0")) port.setCapab_poe(Boolean.FALSE);
		  else port.setCapab_poe(Boolean.TRUE);
		  
		  test = jsonObj.get("capab_uplink").toString();
		  if(test.equals("0")) port.setCapab_uplink(Boolean.FALSE);
		  else port.setCapab_uplink(Boolean.TRUE);
		  
		  test = jsonObj.get("capab_cluster").toString();
		  if(test.equals("0")) port.setCapab_cluster(Boolean.FALSE);
		  else port.setCapab_cluster(Boolean.TRUE);
		  
		  test = jsonObj.get("ha_mirrored_uplink").toString();
		  if(test.equals("0")) port.setHa_mirrored_uplink(Boolean.FALSE);
		  else port.setHa_mirrored_uplink(Boolean.TRUE);
		  
		return port;
	}
	
	/**
	 * This method parses a JsonObject that contains a SteelConnect Port details and will build a SconPort object accordingly
	 * @param jsonObj the JsonObject that contains SteelConnect port details
	 * @return a SconPort object
	 */
	public static JsonObject buildSconJsonObject(SconObject obj) {
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		SconPort port = (SconPort)obj;
		jsonBuilder
			.add("name", port.getName())
			.add("port_id", port.getPortId())
			.add("node", port.getNode())
			.add("type", port.getType())
			.add("mac", port.getMac())
			.add("switch_id", port.getSwitchId())
			.add("tag", port.getTag())
			.add("speeds", port.getSpeeds())
			.add("speed", port.getSpeed())
			.add("patchlabel", port.getPatchlabel())
			.add("segment",port.getSegment())
			.add("uplink", port.getUplink())
			.add("portal", port.getPortal())
			.add("virtual_mac", port.getVirtualMac())
			.add("mgmt_config_type", port.getMgmt_config_type())
			.add("mgmt_ipv4", port.getMgmt_ipv4())
			.add("mgmt_gw_ipv4",port.getMgmt_gw_ipv4())
			.add("mgmt_ipv6",port.getMgmt_ipv6())
			.add("mgmt_gw_ipv6", port.getMgmt_gw_ipv6())
			.add("mgmt_dns_ipv4",port.getMgmt_dns_ipv4())
			.add("bridge_with", port.getBridge_with())
			.add("ifname", port.getIfname())
			.add("dcinterface", port.getDcinterface())
			.add("autotrunk",port.isAutotrunk())
			.add("auto",port.isAuto())
			.add("autocfg",port.isAutocfg())
			.add("tagged",port.isTagged())
			.add("vsh_aux_enabled",port.isVsh_aux_enabled())
			.add("vsh_primary_enabled",port.isVsh_primary_enabled())
			.add("cluster_enabled",port.isCluster_enabled())
			.add("data_enabled",port.isData_enabled())
			.add("mgmt_enabled",port.isMgmt_enabled())
			.add("poe_disabled",port.isPoe_disabled())
			.add("capab_multizone",port.isCapab_multizone())
			.add("capab_vsh_aux",port.isCapab_vsh_aux())
			.add("capab_mgmt",port.isCapab_mgmt())
			.add("capab_lan",port.isCapab_lan())
			.add("capab_poe",port.isCapab_poe())
			.add("capab_uplink",port.isCapab_uplink())
			.add("capab_cluster",port.isCapab_cluster())
			.add("ha_mirrored_uplink",port.isHa_mirrored_uplink());
		
		json = jsonBuilder.build();
		
		return json;
	}
	
	/**
	 * Returns a SconPort object based on its ID
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param objId The Id of the site we are looking for
	 * @return a SConPort object that matches objId or null if not found
	 */
	public static SconObject get(String realmUrl, String objId,String orgID) {
		SconPort port = null;
		
		String url = realmUrl + API_PREFIX+"port/"+objId;
		
		JsonObject jsonObj = null;
		try {
			jsonObj = SconRESTOperations.GetData(url);
			if(jsonObj!=null){
				port = (SconPort) convertFromJson(jsonObj);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return port;
	}

	/**
	 * Lists all SconPort that it gets from the SteelConnect Organization
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @return a list of SconPort objects
	 */
	public static List<SconObject> getAll(String realmUrl, String orgID) {
		List<SconObject> objectList = new ArrayList<SconObject>();
		
		String url = realmUrl + API_PREFIX +"org/"+orgID+"/ports";
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
	 * Updates a SconPort in a particular SteelConnect organization via the REST API
	 * @return SconObject the port that was updated
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconPort to be updated on SteelConnect
	 */
	public static SconObject update(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX+"port/"+obj.getId();
		
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

		
}
