/**
 * 
 */
package com.nextpoorslob.tagsandfilters;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.Test;

import com.nextpoorslob.junit5.b040.service.Calculator;
import com.nextpoorslob.junit5.b040.service.IntegerCalculator;


/**
 * Assumptions that fail leave no trace in the JUnit runner's output!
 *
 */
class AssumptionTest {

	private final Calculator<Integer> calculator = new IntegerCalculator();

	/**
	 * If this is NOT run unless an environmental variable ENV exists and is set to "CI".
	 */
	@Test
	void testOnlyOnCiServer() {
		assumeTrue("CI".equals(System.getenv("ENV")));
		// Test goes here!
		fail("This is not a CI server!");
	}

	/**
	 * If this is run only when an environmental variable ENV exists and is set to "CI".
	 */
	@Test
	void testNotOnACiServer() {
		assumeFalse("CI".equals(System.getenv("ENV")), () -> fail("This is not a DEV server!  Do NOT execute."));

		System.out.println("testOnlyOnDeveloperWorkstation - This should print!");
	}

	/**
	 * These tests always run, but the first test is ignored if we are not in a "CI" environment.
	 */
	@Test
	void testInAllEnvironments() {
		assumingThat("CI".equals(System.getenv("ENV")), () -> {
			// Do not perform this assertions when NOT on the CI server!
			assertEquals(5, calculator.add(4, 2));
		});
		// perform these assertions in all environments
		assertEquals(42, calculator.subtract(50, 8));
	}
}
