
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

import com.riverbed.jsconapi.beans.SconNode;
import com.riverbed.jsconapi.beans.SconObject;
import com.riverbed.jsconapi.util.SconUtil;

/**
 * This class provides all the primitives to manage a Node on SteelConnect. A node is either a Gateway, SH-SD, Access Point or a Switch
 * It will make the appropriate REST API calls to a given SCM organization.
 * 
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
public class SconNodeAPI implements SconObjectAPI {

	/**
	 * This method parses a JsonObject that contains SteelConnect Node details and will build a SconNode object accordingly
	 * @param jsonObj the JsonObject that contains SteelConnect Node details
	 * @return a SconNode object
	 */
	public static SconObject convertFromJson(JsonObject jsonObj) {
		SconNode node = new SconNode();
		if(jsonObj==null) return null;
		
		JsonValue tempValue;
		tempValue = jsonObj.get("site");
		if(tempValue!=null) node.setSite(jsonObj.getString("site"));
		
	
		tempValue = jsonObj.get("local_as");
		if(tempValue!=null)  node.setLocalAS(jsonObj.getString("local_as"));
		
		tempValue = jsonObj.get("model");
		if(tempValue!=null)  node.setModel(jsonObj.getString("model"));
	
		tempValue = jsonObj.get("router_id");
		if(tempValue!=null)  node.setRouterId(jsonObj.getString("router_id"));
		
		String test = jsonObj.get("disable_stp").toString();
		if(test.equals("0")) node.setDisableStp(Boolean.FALSE);
		  else node.setDisableStp(Boolean.TRUE);
		
		test = jsonObj.get("simulated").toString();
		if(test.equals("0")) node.setSimulated(Boolean.FALSE);
		  else node.setSimulated(Boolean.TRUE);
		
	
		String[] uplinks = new String[0];
		if(!jsonObj.isNull("uplinks")) uplinks = SconUtil.jsonArrayToStringArray(jsonObj.getJsonArray("uplinks"));
		node.setUplinks(uplinks);
		
		String[] radios = new String[0];
		if(!jsonObj.isNull("radios")) radios = SconUtil.jsonArrayToStringArray(jsonObj.getJsonArray("radios"));
		node.setRadios(radios);
		
		tempValue = jsonObj.get("location");
		if(!jsonObj.isNull("location")) node.setLocation(jsonObj.getString("location"));
		
		tempValue = jsonObj.get("serial");
		if(tempValue!=null)  node.setSerial(jsonObj.getString("serial"));
		
		tempValue = jsonObj.get("license");
		if(tempValue!=null)  node.setLicense(jsonObj.getString("license"));
		
		String[] ports = new String[0];
		if(!jsonObj.isNull("ports")) ports = SconUtil.jsonArrayToStringArray(jsonObj.getJsonArray("ports"));
		node.setPorts(ports);
		
		
		test = jsonObj.get("sitelink").toString();
		if(test.equals("0")) node.setSitelink(Boolean.FALSE);
		  else node.setSitelink(Boolean.TRUE);
		
		tempValue = jsonObj.get("ha_mgmt_ip");
		if(tempValue!=null)  node.setHaMgmtIP(jsonObj.getString("ha_mgmt_ip"));
		
		tempValue = jsonObj.get("ha_partner");
		if(tempValue!=null)  node.setHaPartner(jsonObj.getString("ha_partner"));
		
		tempValue = jsonObj.get("ha_dedicated_port");
		if(tempValue!=null)  node.setHaDedicatedPort(jsonObj.getString("ha_dedicated_port"));
		
		tempValue = jsonObj.get("ha_control_link");
		if(tempValue!=null)  node.setHaControlLink(jsonObj.getString("ha_control_link"));
		
		test = jsonObj.get("scm_managed_vsh").toString();
		if(test.equals("0")) node.setScm_managed_vsh(Boolean.FALSE);
		  else node.setScm_managed_vsh(Boolean.TRUE);
		
		test = jsonObj.get("ha_clone_mac").toString();
		if(test.equals("0")) node.setHa_clone_mac(Boolean.FALSE);
		  else node.setHa_clone_mac(Boolean.TRUE);
		
		return node;
	}

	/**
	 * This method creates a JSON object to make REST API calls based on the SconNode object's attributes.
	 * @param obj a SconNode object 
	 * @return a JsonOject built with SconNode Attributes or null if the object was from a different instance.
	 */
	public static JsonObject buildSconJsonObject(SconObject obj) {
		
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		SconNode node = (SconNode) obj;
		
		JsonArrayBuilder uplinksBuilder = Json.createArrayBuilder();
		if(node.getUplinks()!=null){
			for (String uplink : node.getUplinks()){
				uplinksBuilder.add(uplink);
			}
		}
		
		JsonArrayBuilder radiosBuilder = Json.createArrayBuilder();
		if(node.getRadios()!=null){
			for (String radio : node.getRadios()){
				radiosBuilder.add(radio);
			}
		}
		
		JsonArrayBuilder portsBuilder = Json.createArrayBuilder();
		if(node.getPorts()!=null){
			for (String port : node.getPorts()){
				portsBuilder.add(port);
			}
		}
		
		jsonBuilder
		.add("site",node.getSite())
		.add("model", node.getModel())
		.add("simulated", node.isSimulated())
		.add("serial",node.getSerial())
		.add("local_as",node.getLocalAS())
		.add("router_id",node.getRouterId())
		.add("disable_stp",node.isDisableStp())
		.add("uplinks", uplinksBuilder)
		.add("radios",radiosBuilder)
		.add("location",node.getLocation())
		.add("license",node.getLicense())
		.add("ports",portsBuilder)
		.add("sitelink",node.isSitelink())
		.add("ha_mgmt_ip",node.getHaMgmtIP())
		.add("ha_partner",node.getHaPartner())
		.add("ha_dedicated_port",node.getHaDedicatedPort())
		.add("ha_control_link",node.getHaControlLink())
		.add("scm_managed_vsh",node.isScm_managed_vsh())
		.add("ha_clone_mac",node.isHa_clone_mac());
		
		json = jsonBuilder.build();
		
		return json;
	}
	
	/**
	 * Returns a SconNode object based on its ID
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param objId The Id of the site we are looking for
	 * @return a SConNode object that matches objId or null if not found
	 */
	public static SconObject get(String realmUrl, String objId) {
		SconNode node = null;
		String url = realmUrl + API_PREFIX+"node/"+objId;
		
		JsonObject jsonObj = null;
		try {
			jsonObj = SconRESTOperations.GetData(url);
			if(jsonObj!=null){
				node = (SconNode) convertFromJson(jsonObj);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return node;
	}

	/**
	 * Lists all SconNode that it gets from the SteelConnect Organization
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @return a list of SconNode objects
	 */
	public static List<SconObject> getAll(String realmUrl, String orgID) {
		List<SconObject> objectList = new ArrayList<SconObject>();
		
		String url = realmUrl + API_PREFIX +"org/"+orgID+"/nodes";
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
	 * Register HW appliance on SteelConnect. A Valid Serial number is required to process the request. Registering a Virtual or shadow appliance is recommended.
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The Node to register and that needs to get a Serial number
	 * @return SconObject The SconNode that has been registered
	 * 
	 */
	public static SconObject registerHW(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		String url = realmUrl+API_PREFIX +"org/"+orgID+"/node/register";
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		SconNode node = (SconNode)obj;
		
		jsonBuilder
			.add("site",node.getSite())
			.add("model", node.getModel())
			.add("simulated", node.isSimulated())
			.add("serial",node.getSerial())
			.add("location",node.getLocation());
		json = jsonBuilder.build();
		
		try {
			json = SconRESTOperations.PostData(url, json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		JsonValue tempValue = json.get("id");
		
		if(tempValue!=null){
			String id = SconUtil.removeBrackets(tempValue.toString());
			obj.setId(id);
		}                   
		else return null;
		
		return obj;
	}

	/**
	 * Register VM or Shadow appliance on SteelConnect. 
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The Node to register. For Shadow appliance, have the simulated attribute sset to TRUE.
	 * @return SconObject The SconNode that has been registered
	 * 
	 */
	public static SconObject registerVM(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		String url = realmUrl+API_PREFIX +"org/"+orgID+"/node/virtual/register";
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		SconNode node = (SconNode)obj;
		
		jsonBuilder
			.add("site",node.getSite())
			.add("model", node.getModel())
			.add("simulated", node.isSimulated());
		json = jsonBuilder.build();
		
		try {
			json = SconRESTOperations.PostData(url, json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		JsonValue tempValue = json.get("id");
		
		if(tempValue!=null){
			String id = SconUtil.removeBrackets(tempValue.toString());
			obj.setId(id);
		}                   
		else return null;
		
		return obj;
	}
	
	/**
	 * Updates an appliance in a particular SteelConnect organization via the REST API
	 * @return SconNode the object that was updated
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconNode to be updated on SteelConnect
	 */
	public static SconObject update(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		JsonObject jsonObj = null;
		String url = realmUrl+API_PREFIX+"node/"+obj.getId();
		
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
		} else return null;
		
		return obj;
	}

	/**
	 * Deletes an appliance in a particular SteelConnect organization via the REST API
	 * @return SconNode the object that was deleted
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconNode to be deleted on SteelConnect
	 */
	public static SconObject delete(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		String url = realmUrl+API_PREFIX+"node/"+obj.getId();
		
		
		try {
			SconRESTOperations.DeleteData(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return obj;
	}

	/**
	 * Reset to factory default an appliance's configuration via the REST API
	 * @return SconNode the object that was reset factory
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param obj The SconNode to be deleted on SteelConnect
	 */
	public static SconObject factoryReset(String realmUrl, SconObject obj) {
		if(obj==null) return null;
		
		String url = realmUrl+API_PREFIX+"node/"+obj.getId()+"/factory_reset";
		
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		json = jsonBuilder.build();
		
		try {
			json = SconRESTOperations.PostData(url, json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		JsonValue tempValue = json.get("id");
		
		return obj;
	}
	
	/**
	 * Reboot an appliance via the REST API
	 * @return SconNode the object that was rebooted
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param obj The SconNode to be rebooted on SteelConnect
	 */
	public static SconObject reboot(String realmUrl, String orgID, SconObject obj) {
		if(obj==null) return null;
		
		String url = realmUrl+API_PREFIX+"node/"+obj.getId()+"/reboot";
		
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		json = jsonBuilder.build();
		
		try {
			json = SconRESTOperations.PostData(url, json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return obj;
	}
	
	/**
	 * Prepare a virtual image of an appliance via the REST API. It could be created in different format: Hyper-V, VMware, Xen...
	 * @return Boolean True if the request is accepted, false if there was a problem
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param obj The SconNode for which we want to create a VM image on SteelConnect
	 */
	public static Boolean createVMImage(String realmUrl, SconObject obj, String imageType) {
		if(obj==null) return null;
		
		String url = realmUrl+API_PREFIX+"node/"+obj.getId()+"/prepare_image";
		JsonObject json = null;
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		
		jsonBuilder
			.add("type",imageType);
		json = jsonBuilder.build();
		
		try {
			json = SconRESTOperations.PostData(url, json);
		} catch (IOException e) {
			return Boolean.FALSE;
		}		
		
		return Boolean.TRUE;
	}
	
	/**
	 * Check the status of image creation of a virtual appliance via the REST API. It could be created in different format: Hyper-V, VMware, Xen...
	 * @return Boolean True if the request is accepted, false if there was a problem
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param obj The SconNode for which we want to check the creation of an VM image on SteelConnect
	 */
	public static String getVMImageStatus(String realmUrl, SconObject obj) {
		if(obj==null) return null;
		
		String url = realmUrl+API_PREFIX+"node/"+obj.getId()+"/image_status";
		JsonObject json = null;
		try {
			 json = SconRESTOperations.GetData(url);
		} catch (IOException e) {
			JsonError err = SconRESTOperations.jsonErrorHandler(json);
			return err.getMessage();
		}		
		return json.getString("image_file");
	}
	
	public static String[] downloadEC2(String realmUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static SconObject generateSupportPackage(String realmUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static SconObject downloadSupportPackage(String realmUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
