/**
 * 
 */
package com.promineotech.jeep.dao;

import java.math.BigDecimal;
import java.util.Optional;

import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Engine;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.Tire;
import com.promineotech.jeep.entity.color;


public interface JeepOrderDao {

 Optional<Customer> fetchCustomer(String customerId); 
	
 Optional<Jeep> fetchModel(JeepModel model, String trim, int doors);
	
 Optional<color> fetchColor(String colorId);
	
 Optional<Engine> fetchEngine(String engineId);
	
 Optional<Tire> fetchTire(String tireId);

/**
 * @param customer
 * @param jeep
 * @param color
 * @param engine
 * @param tire
 * @param price
 * @return
 */
Order saveOrder(Customer customer, Jeep jeep, color color, Engine engine, Tire tire, BigDecimal price);
	
	
	
	
	

	
	
	}


