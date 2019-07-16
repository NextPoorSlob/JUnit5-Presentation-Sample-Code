package com.nextpoorslob.junit5.b070.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Examples of Lambdas used with assertions. Most of this is from the JUnit5
 * manual.
 * 
 * @author Stephen Gelman
 *
 */
class LambdaAssertsTest {

	private final Calculator<Integer> calculator = new IntegerCalculator();

	@Test
	void standardAssertions() {
		assertEquals(2, calculator.add(1, 1)); // No change
		assertEquals(4, calculator.multiply(2, 2), "The optional failure message is now the last parameter");
		assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
				+ "to avoid constructing complex messages unnecessarily.");
	}

	@Test
	void groupedAssertions() {
		// In a grouped assertion all assertions are executed, and all
		// failures will be reported together.
		assertAll("transitive", 
				() -> assertEquals(calculator.add(2, 3), calculator.add(3, 2)),
				() -> assertEquals(calculator.multiply(10, 5), calculator.multiply(5, 10)));
	}

	@Test
	void dependentAssertions() {
		// Within a code block, if an assertion fails the 
		// subsequent code in the same
		// block will be skipped.
		assertAll("properties", () -> {
			Integer result = calculator.multiply(10, 5);
			assertNotNull(result);
			// Executed only if the previous assertion is valid.
			assertAll("result = 50", 
					() -> assertTrue(result > 49), 
					() -> assertTrue(result < 51),
					() -> assertTrue(result == 50)
			);
		}, () -> {
			// Grouped assertion, so processed independently 
			// of results of first assertions.
			Integer result = calculator.add(10, 5);
			assertNotNull(result);
			// Executed only if the previous assertion is valid.
			assertAll("transitive", 
					() -> assertTrue(result > 0),
					() -> assertEquals(result, calculator.add(5, 10)));
		});
	}
}
