/**
 * 
 */
package com.promineotech.jeep.service;

import java.math.BigDecimal;

import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Engine;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.jeep.entity.Tire;
import com.promineotech.jeep.entity.color;

/**
 * @author manuelnava
 *
 */
public interface JeepOrderService {

	/**
	 * @param orderrequest
	 * @return
	 */
	Order createOrder(OrderRequest orderrequest);

	/**
	 * @param customer
	 * @param jeep
	 * @param color
	 * @param engine
	 * @param tire
	 * @param price
	 * @return
	 */
	Order SaveOrder(Customer customer, Jeep jeep, color color, Engine engine, Tire tire, BigDecimal price);

}
