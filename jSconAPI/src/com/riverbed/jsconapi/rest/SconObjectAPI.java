package com.riverbed.jsconapi.rest;

import java.util.List;

import javax.json.JsonObject;

import com.riverbed.jsconapi.beans.SconObject;

/**
 * This interfaces defines the primitives to create, update, get or delete any objects on SteelConnect. 
 *
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
public interface SconObjectAPI {
	
	//it is used to build the URL and concatenated with realmUrl. To be modified when new API are released. 
	public static final String API_PREFIX = "/api/scm.config/1.0/";
	
	/**
	 * This method parses a JsonObject that contains SteelConnect Object details and will build a SconObject object accordingly
	 * @param jsonObj the JsonObject that contains SteelConnect object details
	 * @return a SconObject object
	 */
	public SconObject convertFromJson (JsonObject jsonObj);
	
	/**
	 * This method creates a JSON object to make REST API calls based on the SconObject object's attributes.
	 * @param obj a SconObject object 
	 * @return a JsonOject built with SconObject Attributes or null if the object was from a different instance.
	 */
	public JsonObject buildSconJsonObject(SconObject obj);
	
	/**
	 * Returns a SconObject object based on its name
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @return a List of all SConObject objects of a particular instance available on the SteelConnect organization
	 */
	public SconObject getByName(String realmUrl,String objectName,String orgID);
	
	/**
	 * Returns a SconObject object based on its ID
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param objId The Id of the application we are looking for
	 * @return a SConObject object that matches objId or null if not found
	 */
	public SconObject get(String realmUrl,String objId);
	
	/**
	 * Lists all SconObject of a particular instance that it gets from the SteelConnect Organization
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @return a list of SconObject objects
	 */
	public List<SconObject> getAll(String realmUrl, String orgID);
	
	/**
	 * Creates a SconObject in a particular SteelConnect organization via the REST API
	 * @return SconObject the object that was created
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconObject to be created on SteelConnect
	 */
	public SconObject create(String realmUrl,String orgID,SconObject obj);
	

	/**
	 * Updates a SconObject in a particular SteelConnect organization via the REST API
	 * @return SconObject the object that was Updated
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconObject to be updated on SteelConnect
	 */
	public SconObject update(String realmUrl,String orgID,SconObject obj);
	
	/**
	 * Deletes a SconObject in a particular SteelConnect organization via the REST API
	 * @return SconObject the object that was deleted
	 * @param realmUrl The URL of SteelConnect Realm in the following format "https://xyz.riverbed.cc"
	 * @param orgID The id of the SteelConnect organization to make the call to. orgId will be in the following format "org-abc-xyz"
	 * @param obj The SconObject to be deleted on SteelConnect
	 */
	public SconObject delete(String realmUrl,String orgID,SconObject obj);

	

}
