package com.riverbed.jsconapi.test.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.riverbed.jsconapi.beans.SconSite;
import com.riverbed.jsconapi.beans.SconZone;
import com.riverbed.jsconapi.rest.SconSiteAPI;
import com.riverbed.jsconapi.rest.SconZoneAPI;

class SconZoneAPITest {

	private static String url;
	private static String orgID;
	private static SconZone zone = null;
	private static SconSite site = null;
	
	@BeforeAll
	public static void warmUp() {
		url = System.getenv("url");
		orgID = System.getenv("orgID");
		site = new SconSite("JunitTest", "Junit Testing", "680 Folsom Street", "San Francisco", "United States");
		site = (SconSite) SconSiteAPI.create(url, orgID, site);
	}
	

	
	@AfterAll
	public static void terminate() {
		SconSiteAPI.delete(url, orgID, site);
		System.clearProperty("url");
		System.clearProperty("orgID");
		System.clearProperty("username");
		System.clearProperty("password");
	}
	
	
	@BeforeEach
	public void init() {
		zone = new SconZone(site.getId(),"JUNIT Test zone");
	}
	
	@AfterEach
	public void done() {
		zone = null;
	}
	
	@Test
	void testGet() {
		zone = (SconZone)SconZoneAPI.create(url, orgID, zone);
		assertNotNull(SconZoneAPI.get(url, zone.getId(), orgID));
		SconZoneAPI.delete(url, orgID, zone);
	}

	@Test
	void testGetAll() {
		zone = (SconZone)SconZoneAPI.create(url, orgID, zone);
		assertNotNull(SconZoneAPI.getAll(url, orgID));
		SconZoneAPI.delete(url, orgID, zone);
	}

	@Test
	void testCreate() {
		zone = (SconZone)SconZoneAPI.create(url, orgID, zone);
		assertNotNull(zone);
		SconZoneAPI.delete(url, orgID, zone);
	}

	@Test
	void testUpdate() {
		zone = (SconZone)SconZoneAPI.create(url, orgID, zone);
		zone.setName("JUNIT UPDATE TEST");
		SconZone updatedZone = (SconZone)SconZoneAPI.update(url, orgID, zone);
		assertEquals(zone.getId(),updatedZone.getId());
		assertEquals(zone.getName(),updatedZone.getName());
		SconZoneAPI.delete(url, orgID, zone);
	}

	@Test
	void testDelete() {
		zone = (SconZone)SconZoneAPI.create(url, orgID, zone);
		String zoneId = zone.getId();
		SconZoneAPI.delete(url, orgID, zone);
		assertNull(SconZoneAPI.get(url, zoneId, orgID));
	}

}
