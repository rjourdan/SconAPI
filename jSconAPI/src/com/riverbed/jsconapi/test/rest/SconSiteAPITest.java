/**
 * 
 */
package com.riverbed.jsconapi.test.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.riverbed.jsconapi.beans.SconSite;
import com.riverbed.jsconapi.rest.SconSiteAPI;

/**
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
class SconSiteAPITest {

	private static String url;
	private static String orgID;
	private static SconSite site = null;
	
	@BeforeEach
	public void init() {
		url = System.getenv("url");
		orgID = System.getenv("orgID");
		site = new SconSite("JunitTest", "Junit Testing", "680 Folsom Street", "San Francisco", "United States");
	}
	
	@AfterEach
	public void done() {
		site = null;
		System.clearProperty("url");
		System.clearProperty("orgID");
		System.clearProperty("username");
		System.clearProperty("password");
	}
	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconSiteAPI#get(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGet() {
		site = (SconSite) SconSiteAPI.create(url, orgID, site);
		assertNotNull(SconSiteAPI.get(url, site.getId()));
		SconSiteAPI.delete(url, orgID, site);
		
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconSiteAPI#getAll(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGetAll() {
		site = (SconSite) SconSiteAPI.create(url, orgID, site);
		assertNotNull(SconSiteAPI.getAll(url, orgID));
		SconSiteAPI.delete(url, orgID, site);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconSiteAPI#create(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testCreate() {
		site = (SconSite) SconSiteAPI.create(url, orgID, site);
		assertNotNull(site);
		SconSiteAPI.delete(url, orgID, site);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconSiteAPI#update(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testUpdate() {
		site = (SconSite) SconSiteAPI.create(url, orgID, site);
		site.setLongName("valid");
		SconSite updatedSite = (SconSite)SconSiteAPI.update(url, orgID,site);
		assertEquals(site.getId(),updatedSite.getId());
		assertEquals(site.getLongName(),updatedSite.getLongName());
		SconSiteAPI.delete(url, orgID, site);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconSiteAPI#delete(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testDelete() {
		site = (SconSite) SconSiteAPI.create(url, orgID, site);
		String siteId = site.getId();
		SconSiteAPI.delete(url, orgID, site);
		assertNull(SconSiteAPI.get(url, siteId));
	}

}
