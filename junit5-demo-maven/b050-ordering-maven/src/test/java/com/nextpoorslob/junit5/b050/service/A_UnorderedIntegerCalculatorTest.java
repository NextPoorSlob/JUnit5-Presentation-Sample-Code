/**
 * 
 */
package com.nextpoorslob.junit5.b050.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests the Integer implementation of the Calculator interface.
 * @author Stephen Gelman
 *
 */
class A_UnorderedIntegerCalculatorTest {

	private final Calculator<Integer> calculator = new IntegerCalculator();
	
	@Test
	void testAdd_whenZeroValues_thenReturnZero() {

		assertEquals(0, calculator.add(0, 0));
	}

	@Test
	void testAdd_when10PlusNegative5_thenReturn5() {

		assertEquals(5, calculator.add(10, -5));
	}

	@Test
	void testSubtract_whenZeroValues_thenReturnZero() {

		assertEquals(0, calculator.subtract(0, 0));
	}

	@Test
	void testSubtract_when10MinusNegative5_thenReturn15() {

		assertEquals(15, calculator.subtract(10, -5));
	}

}
