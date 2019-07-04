package com.nextpoorslob.junit5.a030.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Tests the Integer implementation of the Calculator interface using the test
 * version of the Spring framework.
 * 
 * @author Stephen Gelman
 *
 */
@SpringBootTest 		// Includes @ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc	// Needed to configure the MockMvc
class IntegerCalculatorControllerIntegrationTest {

	// Not necessary if you are testing strictly through the MockMvc
	@Autowired
	private IntegerCalculatorController controller;

	@Autowired
	private MockMvc mockMvc;

	/**
	 * Tests the framework in isolation. Not really necessary but makes a good
	 * sanity check.
	 * 
	 * @throws Exception if the framework fails to initialize.
	 */
	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		// Or use Hamcrest:
		assertThat(controller, notNullValue());
	}

	/**
	 * Tests 0 + 0 = 0 THROUGH THE WEB SERVICE, not through POJ.
	 * @throws Exception if your annotation are ... defective.
	 */
	@Test
	void add_whenZeroPlusZero_thenReturnZero() throws Exception {

		mockMvc.perform(get("/add/0/0"))
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("0")));

	}

	/**
	 * Tests 1000 + 10,000 = 11,000 THROUGH THE WEB SERVICE, not through POJ.
	 * @throws Exception if your annotation are ... defective.
	 */
	@Test
	void add_when1000Plus10000_thenReturn11000() throws Exception {

		mockMvc.perform(get("/add/1000/10000"))
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("11000")));

	}

}
