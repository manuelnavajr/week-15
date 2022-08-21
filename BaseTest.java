/**
 * 
 */
package com.promineotech.jeep.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import lombok.Getter;

/**
 * @author manuelnava
 *
 */
public class BaseTest {
	@LocalServerPort
	private int serverPort;
	
	@Autowired
	@Getter
	private TestRestTemplate restTemplate;
	/**
	 * 
	 * @return
	 */ 
	protected String GetBaseURIForJeeps() {
		return String.format("http://localhost:%d/jeeps", serverPort);
	
	}
	/**
	 * 
	 * @return
	 */
	protected String GetBaseURIForOrders() {
		return String.format("http://localhost:%d/orders", serverPort);
}
}