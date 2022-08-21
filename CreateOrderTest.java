
package com.promineotech.jeep.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.web.client.RestTemplate;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.promineotech.jeep.controller.support.CreateOrderTestSupport;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(
	scripts = {
    "classpath:flyway/migrations/migrations1",
		"classpath:flyway/migrations/migrations2"}, 
    config = @SqlConfig(encoding = "utf-8"))
class CreateOrderTest extends CreateOrderTestSupport{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	
	
	@Test
	void testCreateOrderReturnSuccess201() {
		String body = createOrderBody();
		String uri = GetBaseURIForOrders();
		
		int numRowsOrders = JdbcTestUtils.countRowsInTable(jdbcTemplate, "orders");
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
		
		ResponseEntity<Order> response = restTemplate.exchange(uri,
			    HttpMethod.POST, bodyEntity, Order.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		
		
		assertThat(response.getBody()).isNotNull();
		
		Order order = response.getBody();
		assertThat(order.getCustomer().getCustomerId()).isEqualTo("MORISON_LINA");
		assertThat(order.getModel().getModelId()).isEqualTo(JeepModel.WRANGLER);
		assertThat(order.getModel().getTrimLevel()).isEqualTo("Sport Altitude");
		assertThat(order.getModel().getNumDoors()).isEqualTo(4);
		assertThat(order.getColor().getColorId()).isEqualTo("EXT_NACHO");
		assertThat(order.getEngine().getEngineId()).isEqualTo("2_0_TURBO");
		assertThat(order.getTire().getTireId()).isEqualTo("35_TOYO");
		assertThat(order.getOptions()).hasSize(6);

	}
	
		
		
		

	/**
	 * @param httpStatus
	 * @return
	 */
	private Object assertThat(HttpStatus httpStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	private Object GetRestTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

}
