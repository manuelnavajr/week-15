/**
 * 
 */
package com.promineotech.jeep.controller.support;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

/**
 * @author manuelnava
 *
 */
public class FetchJeepTestSupport extends BaseTest {
	private List<Jeep> buildExpected() {
		List<Jeep> list = new LinkedList<>();
		// formatter:off
		list.add(Jeep.builder()
				.modelId(JeepModel.Wrangler)
				.trimLevel("Sport")
				.numDoors(2)
				.wheelSize(17)
				.BasePrice(new BigDecimal("28475.00"))
				.build());
		list.add(Jeep.builder()
			.modelId(JeepModel.Wrangler)
			.trimLevel("Sport")
			.numDoors(2)
			.wheelSize(17)
			.BasePrice(new BigDecimal("31975.00"))
			.build());

		
		
		
		// formatter:on
				
		
		return list;
		
	}
	
}
