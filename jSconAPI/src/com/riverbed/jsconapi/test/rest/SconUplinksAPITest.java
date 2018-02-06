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

import com.riverbed.jsconapi.beans.SconSite;
import com.riverbed.jsconapi.beans.SconUplink;
import com.riverbed.jsconapi.beans.SconWan;
import com.riverbed.jsconapi.rest.SconSiteAPI;
import com.riverbed.jsconapi.rest.SconUplinkAPI;
import com.riverbed.jsconapi.rest.SconWanAPI;

/**
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
class SconUplinksAPITest {

	private static String url;
	private static String orgID;
	private static SconUplink uplink = null;
	private static SconSite site = null;
	private static SconWan wan = null;
	
	@BeforeAll
	public static void warmUp() {
		System.out.println("warm up");
		url = System.getenv("url");
		orgID = System.getenv("orgID");
		site = new SconSite("JunitTest", "Junit Testing", "680 Folsom Street", "San Francisco", "United States");
		site = (SconSite) SconSiteAPI.create(url, orgID, site);
		wan = new SconWan("cable", "Xfinity cable", Boolean.TRUE);
		wan = (SconWan)SconWanAPI.create(url, orgID, wan);	
	}
	
	@BeforeEach
	public void init() {
		
	
		uplink = new SconUplink("comcast",site.getId(),null,null,"192.168.0.1","192.168.0.254",wan.getId(),"",0,"dhcpc",true,10000);
	}
	
	@AfterEach
	public void done() {
		System.out.println("completed");
		uplink = null;	
	}
	
	@AfterAll
	public static void terminate() {
		System.out.println("terminate");
		SconWanAPI.delete(url, orgID, wan);
		SconSiteAPI.delete(url, orgID, site);
		System.clearProperty("url");
		System.clearProperty("orgID");
		System.clearProperty("username");
		System.clearProperty("password");
	}
	
	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconUplinkAPI#get(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGet() {
		uplink = (SconUplink)SconUplinkAPI.create(url, orgID, uplink);
		assertNotNull(SconUplinkAPI.get(url, uplink.getId()));
		SconUplinkAPI.delete(url, orgID, uplink);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconUplinkAPI#getAll(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGetAll() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconUplinkAPI#create(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testCreate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconUplinkAPI#update(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconUplinkAPI#delete(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testDelete() {
		fail("Not yet implemented"); // TODO
	}

}
