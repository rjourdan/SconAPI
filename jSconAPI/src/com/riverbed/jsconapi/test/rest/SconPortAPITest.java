/**
 * 
 */
package com.riverbed.jsconapi.test.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.riverbed.jsconapi.beans.SconPort;

/**
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
class SconPortAPITest {

	private static String url;
	private static String orgID;
	private static SconPort port = null;
	
	@BeforeAll
	public static void init() {
		url = System.getenv("url");
		orgID = System.getenv("orgID");
		port = new SconPort();
	}
	
	@AfterAll
	public static void done() {
		port = null;
		System.clearProperty("url");
		System.clearProperty("orgID");
		System.clearProperty("username");
		System.clearProperty("password");
	}
	
	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPortAPI#get(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGet() {
		
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPortAPI#getAll(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGetAll() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconPortAPI#update(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

}
