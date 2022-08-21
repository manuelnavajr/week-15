/**
 * 
 */
package com.promineotech.jeep.service;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.jeep.dao.JeepOrderDao;
import com.promineotech.jeep.entity.Customer;
import com.promineotech.jeep.entity.Engine;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.Option;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.jeep.entity.Tire;
import com.promineotech.jeep.entity.color;


@Service
public class DefaultOrderService implements JeepOrderService {

	@Autowired 
	private JeepOrderDao jeepOrderDao;
	
	@Override
	public Order SaveOrder(Customer customer, Jeep jeep, color color,
			Engine engine, Tire tire, BigDecimal price) {
		
		
		return null;
	}
	/**
	   * 
	   * @param orderRequest
	   * @return
	   */
	  private List<Option> getOption(OrderRequest orderRequest) {
	    return jeepOrderDao.fetchOptions(orderRequest.getOptions());
	  }

	  /**
	   * 
	   * @param orderRequest
	   * @return
	   */
	  private Tire getTire(OrderRequest orderRequest) {
	    return jeepOrderDao.fetchTire(orderRequest.getTire())
	        .orElseThrow(() -> new NoSuchElementException(
	            "Tire with ID=" + orderRequest.getTire() + " was not found"));
	  }

	  /**
	   * 
	   * @param orderRequest
	   * @return
	   */
	  private Engine getEngine(OrderRequest orderRequest) {
	    return jeepOrderDao.fetchEngine(orderRequest.getEngine())
	        .orElseThrow(() -> new NoSuchElementException(
	            "Engine with ID=" + orderRequest.getEngine() + " was not found"));
	  }

	  /**
	   * 
	   * @param orderRequest
	   * @return
	   */
	  private Color getColor(OrderRequest orderRequest) {
	    return jeepOrderDao.fetchColor(orderRequest.getColor())
	        .orElseThrow(() -> new NoSuchElementException(
	            "Color with ID=" + orderRequest.getColor() + " was not found"));
	  }

	  /**
	   * 
	   * @param orderRequest
	   * @return
	   */
	  private Jeep getModel(OrderRequest orderRequest) {
	    return jeepOrderDao
	        .fetchModel(orderRequest.getModel(), orderRequest.getTrim(),
	            orderRequest.getDoors())
	        .orElseThrow(() -> new NoSuchElementException("Model with ID="
	            + orderRequest.getModel() + ", trim=" + orderRequest.getTrim()
	            + orderRequest.getDoors() + " was not found"));
	  }

	  /**
	   * 
	   * @param orderRequest
	   * @return
	   */
	  private Customer getCustomer(OrderRequest orderRequest) {
	    return jeepOrderDao.fetchCustomer(orderRequest.getCustomer())
	        .orElseThrow(() -> new NoSuchElementException("Customer with ID="
	            + orderRequest.getCustomer() + " was not found"));
	  }
	@Override
	public Order createOrder(OrderRequest orderrequest) {
		// TODO Auto-generated method stub
		return null;
	}
}
