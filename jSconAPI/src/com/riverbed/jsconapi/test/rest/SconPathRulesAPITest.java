/**
 * 
 */
package com.riverbed.jsconapi.test.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.riverbed.jsconapi.beans.SconApp;
import com.riverbed.jsconapi.beans.SconPathRules;
import com.riverbed.jsconapi.beans.SconSite;
import com.riverbed.jsconapi.beans.SconWan;
import com.riverbed.jsconapi.rest.SconAppAPI;
import com.riverbed.jsconapi.rest.SconPathRulesAPI;
import com.riverbed.jsconapi.rest.SconSiteAPI;
import com.riverbed.jsconapi.rest.SconWanAPI;

/**
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */

class SconPathRulesAPITest {

	private static String url;
	private static String orgID;
	private static SconPathRules pr;
	private static SconSite site = null;
	private static SconWan wan = null;
	private static String[] pathPreference = null;
	private static SconApp app = null;
	
	@BeforeAll
	public static void warmUp() {
		url = System.getenv("url");
		orgID = System.getenv("orgID");
		site = new SconSite("JunitTest", "Junit Testing", "680 Folsom Street", "San Francisco", "United States");
		site = (SconSite) SconSiteAPI.create(url, orgID, site);
		wan = new SconWan("cable", "Xfinity cable", Boolean.TRUE);
		wan = (SconWan)SconWanAPI.create(url, orgID, wan);
		pathPreference = new String[1];
		pathPreference[0] = wan.getId();
		app = (SconApp) SconAppAPI.getByName(url, "Bittorrent", orgID);
	}
	
	@BeforeEach
	public void init() {
		
		pr = new SconPathRules("Junit Test rule",SconPathRules.DST_APPS, SconPathRules.SRC_GUESTS,SconPathRules.QOS_LOW, pathPreference, true,app.getId());
		
	}
	
	@AfterEach
	public void done() {
		pr = null;	
	}
	
	@AfterAll
	public static void terminate() {
		SconWanAPI.delete(url, orgID, wan);
		SconSiteAPI.delete(url, orgID, site);
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
		pr = (SconPathRules)SconPathRulesAPI.create(url, orgID, pr);
		assertNotNull(SconPathRulesAPI.get(url, pr.getId()));
		SconPathRulesAPI.delete(url, orgID, pr);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPathRulesAPI#getByName(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGetByName() {
		pr = (SconPathRules)SconPathRulesAPI.create(url, orgID, pr);
		assertNotNull(SconPathRulesAPI.getAll(url, orgID));
		SconPathRulesAPI.delete(url, orgID, pr);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPathRulesAPI#create(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testCreate() {
		pr = (SconPathRules)SconPathRulesAPI.create(url, orgID, pr);
		assertNotNull(pr);
		SconPathRulesAPI.delete(url, orgID, pr);

	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPathRulesAPI#update(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testUpdate() {
		pr = (SconPathRules)SconPathRulesAPI.create(url, orgID, pr);
		pr.setActive(false);
		SconPathRules updatedPR =  (SconPathRules)SconPathRulesAPI.update(url, orgID, pr);
		assertEquals(pr.getId(), updatedPR.getId());
		assertFalse(updatedPR.isActive());
		SconPathRulesAPI.delete(url, orgID, pr);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPathRulesAPI#delete(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testDelete() {
		pr = (SconPathRules)SconPathRulesAPI.create(url, orgID, pr);
		String prID = pr.getId();
		SconPathRulesAPI.delete(url, orgID, pr);
		assertNull(SconPathRulesAPI.get(url, prID));
	}

}
