/**
 * 
 */
package com.promineotech.jeep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

/**
 * @author manuelnava
 *
 */
@Data
@Builder

public class Order {
	  private Long orderPK;
	  @JsonIgnore
	  public Long getOrderPK() {
	    return orderPK;
	  }
	  
	  
}
