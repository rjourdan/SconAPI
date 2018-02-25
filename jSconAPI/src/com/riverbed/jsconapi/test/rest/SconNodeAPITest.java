/**
 * 
 */
package com.riverbed.jsconapi.test.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.riverbed.jsconapi.beans.SconNode;
import com.riverbed.jsconapi.rest.SconNodeAPI;

/**
 * @author rjourdan <a href="mailto:romain.jourdan@gmail.com">romain.jourdan@gmail.com</a>
 * @version 1.0
 */
class SconNodeAPITest {

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#getAll(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGetAll() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#registerHW(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testRegisterHW() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#registerVM(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testRegisterVM() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#update(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#delete(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testDelete() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#factoryReset(java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testFactoryReset() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#reboot(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testReboot() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#createVMImage(java.lang.String, com.riverbed.jsconapi.beans.SconObject, java.lang.String)}.
	 */
	@Test
	void testCreateVMImage() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#getVMImageStatus(java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testGetVMImageStatus() {
		SconNode node = new SconNode();
		node.setId("node-3c8f5061c674bda6");
		String fileName = SconNodeAPI.getVMImageStatus("https://riverbed-tme.riverbed.cc", node);
		System.out.println("EC2 name "+fileName);
		assertNotNull(fileName);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#downloadEC2(java.lang.String, com.riverbed.jsconapi.beans.SconObject, java.lang.String)}.
	 */
	@Test
	void testDownloadEC2() {
		SconNode node = new SconNode();
		node.setId("node-3c8f5061c674bda6");
		String ec2 = SconNodeAPI.downloadEC2("https://riverbed-tme.riverbed.cc", node, "node-3c8f5061c674bda6-VqUN5ufzM9.txt");
		System.out.println("EC2 file "+ec2);
		assertNotNull(ec2);
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#generateSupportPackage(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testGenerateSupportPackage() {
		SconNode node = new SconNode();
		node.setId("node-3c8f5061c674bda6");
		assertTrue(SconNodeAPI.generateSupportPackage("https://riverbed-tme.riverbed.cc", node));
	}

	/**
	 * Test method for {@link com.riverbed.jsconapi.rest.SconNodeAPI#downloadSupportPackage(java.lang.String, java.lang.String, com.riverbed.jsconapi.beans.SconObject)}.
	 */
	@Test
	void testDownloadSupportPackage() {
		fail("Not yet implemented"); // TODO
	}

}
