/**
 * 
 */
package com.promineotech.jeep.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.jeep.service.JeepOrderService;

import lombok.extern.slf4j.XSlf4j;

@RestController
@XSlf4j
public class BasicJeepOrderController implements JeepOrderController{
	
	@Autowired
	private JeepOrderService jeepOrderService;
	
	
	public Order CreateOrder(OrderRequest orderrequest) {
		Log.debug("Order={}", orderrequest);
		return  jeepOrderService.createOrder(orderrequest);
	}

}
