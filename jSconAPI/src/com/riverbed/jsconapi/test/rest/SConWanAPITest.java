/**
 * 
 */
package com.riverbed.jsconapi.test.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.riverbed.jsconapi.beans.SconWan;
import com.riverbed.jsconapi.rest.SconWanAPI;

/**
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
class SConWanAPITest {

	
	private static String url;
	private static String orgID;
	private static SconWan wan = null;
	
	@BeforeEach
	public void init() {
		url = System.getenv("url");
		orgID = System.getenv("orgID");
		wan = new SconWan("satellite", "satellite", Boolean.TRUE);
	}
	
	@AfterEach
	public void done() {
		wan = null;
		System.clearProperty("url");
		System.clearProperty("orgID");
		System.clearProperty("username");
		System.clearProperty("password");
	}
	
	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconWanAPI#get(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGet() {
		wan = (SconWan)SconWanAPI.create(url, orgID, wan);
		assertNotNull(SconWanAPI.get(url, wan.getId(), orgID));
		SconWanAPI.delete(url, orgID, wan);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconWanAPI#getAll(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGetAll() {
		wan = (SconWan)SconWanAPI.create(url, orgID, wan);
		assertNotNull(SconWanAPI.getAll(url, orgID));
		SconWanAPI.delete(url, orgID, wan);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconWanAPI#create(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testCreate() {
		wan = (SconWan)SconWanAPI.create(url, orgID, wan);
		assertNotNull(wan);
		SconWanAPI.delete(url, orgID, wan);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconWanAPI#update(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testUpdate() {
		wan = (SconWan)SconWanAPI.create(url, orgID, wan);
		wan.setName("vdsl");
		SconWan updatedWan = (SconWan)SconWanAPI.update(url, orgID, wan);
		assertEquals(wan.getId(),updatedWan.getId());
		assertEquals(wan.getName(),updatedWan.getName());
		SconWanAPI.delete(url, orgID, wan);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconWanAPI#delete(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testDelete() {
		wan = (SconWan)SconWanAPI.create(url, orgID, wan);
		String wanId = wan.getId();
		SconWanAPI.delete(url, orgID, wan);
		assertNull(SconWanAPI.get(url, wanId, orgID));
	}

}
