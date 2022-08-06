/**
 * 
 */
package com.promineotech.jeep.controller;



import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.context.ActiveProfiles;


import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;


	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	@ActiveProfiles("test")
	@Sql(scripts = {
	    "classpath:flyway/migrations/migrations1",
	    "classpath:flyway/migrations/migrations2"}, 
	    config = @SqlConfig(encoding = "utf-8"))
	class FetchJeepTest {

		private TestRestTemplate restTemplate;
		
		@LocalServerPort
		private int serverPort;
		@Test
		void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
			
		JeepModel model = JeepModel.Wrangler;
		String trim = "Sport";
		String uri = 
				String.format("%s?model=%s&trim=%s", serverPort, model, trim);
		
		ResponseEntity<List<Jeep>> response = 
				GetRestTemplate().exchange(uri, HttpMethod.GET, null,
						new ParameterizedTypeReference<>() {});
			
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		List<Jeep> expected = buildExpected();
		assertThat(response.getBody()).isEqualTo(expected);
	
}
		/**
		 * @return
		 */
		private List<Jeep> buildExpected() {
			// TODO Auto-generated method stub
			return null;
		}
}
