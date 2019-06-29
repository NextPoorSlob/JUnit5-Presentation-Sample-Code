/**
 * 
 */
package com.nextpoorslob.junit5.a020.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import com.nextpoorslob.junit5.a020.service.Calculator;
import com.nextpoorslob.junit5.a020.service.IntegerCalculator;

/**
 * Unit tests the Integer implementation of the Calculator interface in JUnit 4.
 * 
 * @author Stephen Gelman
 *
 */
public class JUnit4IntegerCalculatorTest {

	private final Calculator<Integer> calculator = new IntegerCalculator();

	@Test
	public void testAdd_whenNullValues_thenReturnZero() {

		assertEquals(Integer.valueOf(0), calculator.add(null, null));
	}

	@Test
	public void testAdd_whenZeroValues_thenReturnZero() {

		assertEquals(Integer.valueOf(0), calculator.add(0, 0));
	}

	@Test
	public void testAdd_when1Plus2_thenReturn3() {

		assertEquals(Integer.valueOf(3), calculator.add(1, 2));
	}

	@Test
	public void testAdd_when10PlusNegative5_thenReturn5() {

		assertEquals(Integer.valueOf(5), calculator.add(10, -5));
	}

	@Ignore
	// Why run a failing test?
	@Test
	public void testSubtract() {
		fail("Not yet implemented");
	}

}
