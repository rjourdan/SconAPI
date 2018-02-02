package com.riverbed.jsconapi.test.rest;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.riverbed.jsconapi.beans.SconApp;
import com.riverbed.jsconapi.beans.SconObject;
import com.riverbed.jsconapi.rest.SconAppAPI;


class SconAppAPITest {

	private static String url;
	private static String orgID;
	private static SconApp app = null;
	
	@BeforeAll
	public static void init() {
		url = System.getenv("url");
		orgID = System.getenv("orgID");
		app = new SconApp();
	}
	
	@AfterAll
	public static void done() {
		app = null;
		System.clearProperty("url");
		System.clearProperty("orgID");
		System.clearProperty("username");
		System.clearProperty("password");
	}
	
	@Test
	void testGetByName() {
		 app = (SconApp)SconAppAPI.getByName(url, "Salesforce", orgID);
		 assertEquals(app.getName(),"Salesforce");
	}
	
	@Test
	void testCreate() {
		assertNull(SconAppAPI.create(url, orgID, (SconObject)app));
	}

	@Test
	void testUpdate() {
		assertNull(SconAppAPI.update(url, orgID, (SconObject)app));
	}

	@Test
	void testDelete() {
		assertNull(SconAppAPI.delete(url, orgID, (SconObject)app));
	}

}
