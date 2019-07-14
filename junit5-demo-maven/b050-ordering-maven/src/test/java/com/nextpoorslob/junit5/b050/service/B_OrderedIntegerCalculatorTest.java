/**
 * 
 */
package com.nextpoorslob.junit5.b050.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Unit tests the Integer implementation of the Calculator interface.
 * @author Stephen Gelman
 *
 */
@TestMethodOrder(OrderAnnotation.class)
class B_OrderedIntegerCalculatorTest {

	private final Calculator<Integer> calculator = new IntegerCalculator();
	
	@Test
	@Order(1)
	void testAdd_whenZeroValues_thenReturnZero() {

		assertEquals(0, calculator.add(0, 0));
	}

	@Test
	@Order(2)
	void testAdd_when10PlusNegative5_thenReturn5() {

		assertEquals(5, calculator.add(10, -5));
	}

	@Test
	@Order(3)
	void testSubtract_whenZeroValues_thenReturnZero() {

		assertEquals(0, calculator.subtract(0, 0));
	}

	@Test
	@Order(4)
	void testSubtract_when10MinusNegative5_thenReturn15() {

		assertEquals(15, calculator.subtract(10, -5));
	}

}
