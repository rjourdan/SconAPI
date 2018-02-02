
package com.riverbed.jsconapi.rest;

import java.util.List;

import javax.json.JsonObject;

import com.riverbed.jsconapi.beans.SconObject;

/**
 * 
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
public class SconNodeAPI implements SconObjectAPI {

	@Override
	public SconObject convertFromJson(JsonObject jsonObj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonObject buildSconJsonObject(SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SconObject getByName(String realmUrl, String objectName, String orgID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SconObject get(String realmUrl, String objId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SconObject> getAll(String realmUrl, String orgID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SconObject create(String realmUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SconObject update(String realmUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SconObject delete(String realmUrl, String orgID, SconObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
