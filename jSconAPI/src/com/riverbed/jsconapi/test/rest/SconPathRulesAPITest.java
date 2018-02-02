/**
 * 
 */
package com.riverbed.jsconapi.test.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.riverbed.jsconapi.beans.SconApp;
import com.riverbed.jsconapi.beans.SconPathRules;
import com.riverbed.jsconapi.beans.SconUplink;
import com.riverbed.jsconapi.rest.SconPathRulesAPI;

/**
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */

class SconPathRulesAPITest {

	private static String url;
	private static String orgID;
	private static SconPathRulesAPI prAPI;
	private static SconPathRules pr;
	
	@BeforeAll
	public static void init() {
		url = System.getenv("url");
		orgID = System.getenv("orgID");
		prAPI = null;
		pr = new SconPathRules();
	}
	
	@AfterAll
	public static void done() {
		prAPI = null;
		pr = null;
		System.clearProperty("url");
		System.clearProperty("orgID");
		System.clearProperty("username");
		System.clearProperty("password");
	}
	
	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPathRulesAPI#get(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGet() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPathRulesAPI#getByName(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGetByName() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPathRulesAPI#create(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testCreate() {
		pr.setName("Path Rule Test");
		pr.setDsttype(SconPathRules.DST_APPS);
		//find App ID for Bittorrent
		SconApp app = (SconApp) appAPI.getByName(url, "Bittorrent", orgID);
		pr.setApps(new String[app.getId()]);
		pr.setSrctype(SconPathRules.SRC_GUESTS);
		pr.setQos(SconPathRules.QOS_LOW);
		//find internet uplink
		SconUplink
		SconUplink uplink = (SconUplink)
		pr.setPath_preference(path_preference);

	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPathRulesAPI#update(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPathRulesAPI#delete(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testDelete() {
		fail("Not yet implemented"); // TODO
	}

}
