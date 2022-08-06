/**
 * 
 */
package com.promineotech.jeep.entity;

/**
 * @author manuelnava
 *
 */

	import java.math.BigDecimal;
	import lombok.Builder;
	import lombok.Data;
	
	@Data
	@Builder

	
	public class color {
	  private Long colorPK;
	  private String colorId;
	  private String color;
	  private BigDecimal price;
	  private boolean isExterior;
	}

