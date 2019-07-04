/**
 * 
 */
package com.nextpoorslob.junit5.a030.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.nextpoorslob.junit5.a030.service.Calculator;

/**
 * UNIT test the IntegerCalculatorController: test in isolation.
 * @author Stephen Gelman
 *
 */
@ExtendWith(MockitoExtension.class)
class IntegerCalculatorControlleUnitTest {

	@Mock
	private Calculator<Integer> calculator;
	
	private IntegerCalculatorController controller;
	
	@BeforeEach
	void setup() {
		controller = new IntegerCalculatorController(calculator);
	}
	
	@Test
	void add_whenNullParameters_thenReturnZero() {

		// When
		when(calculator.add(null, null)).thenReturn(0);
		
		// Then
		assertThat(controller.add(null, null), equalTo(ResponseEntity.ok(0)));
		verify(calculator, times(1)).add(null, null);
		
	}

}
