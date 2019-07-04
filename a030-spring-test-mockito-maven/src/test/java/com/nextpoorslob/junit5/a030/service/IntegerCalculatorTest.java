/**
 * 
 */
package com.nextpoorslob.junit5.a030.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Unit tests the Integer implementation of the Calculator interface.
 * 
 * @author Stephen Gelman
 *
 */
class IntegerCalculatorTest {

	private final Calculator<Integer> calculator = new IntegerCalculator();

	@Test
	void testAdd_whenNullValues_thenReturnZero() {

		assertEquals(Integer.valueOf(0), calculator.add(null, null));
	}

	@Test
	void testAdd_whenZeroValues_thenReturnZero() {

		assertEquals(Integer.valueOf(0), calculator.add(0, 0));
	}

	@Test
	void testAdd_when1Plus2_thenReturn3() {

		assertEquals(Integer.valueOf(3), calculator.add(1, 2));
	}

	@Test
	void testAdd_when10PlusNegative5_thenReturn5() {

		assertEquals(Integer.valueOf(5), calculator.add(10, -5));
	}

	@Disabled("Why run a failing test?")
	@Test
	void testSubtract() {
		fail("Not yet implemented");
	}

}
