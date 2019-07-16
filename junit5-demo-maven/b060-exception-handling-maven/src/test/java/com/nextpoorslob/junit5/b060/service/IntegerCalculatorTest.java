/**
 * 
 */
package com.nextpoorslob.junit5.b060.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

/**
 * Catching errors in JUnit5.  The @Test annotation no longer has an expected clause.
 * 
 * @author Stephen Gelman
 *
 */
class IntegerCalculatorTest {

	private final Calculator<Integer> calculator = new IntegerCalculator();

	@Test
	void divide_WhenZeroDividedByZero_ThenCatchTheJUnit3Way() {
		try {
			assertEquals(0, calculator.divide(0, 0));
			fail("Huh?  I should've gotten a divide-by-zero exceptions!");
		} catch (ArithmeticException e) {
			// Worked!
		}
	}
	
	/**
	 * The new way to handle exceptions! Assert the throwable itself.
	 */
	@Test
	void divide_WhenZeroDividedBy0_ThenExpectAnException() {

		assertThrows(ArithmeticException.class, () -> {
			assertEquals(0, calculator.divide(0, 0));
		});
		
		// Since the assertThrows caught the expected error, you could continue
		// your test with additional statements.  But that is being naughty!
	}

	/**
	 * The new way to handle exceptions! Assert the super class.
	 */
	@Test
	void divide_WhenZeroDividedBy0_ThenExpectASuperClass() {

		assertThrows(RuntimeException.class, () -> {
			assertEquals(0, calculator.divide(0, 0));
		});

		// Sneak in an extra test. (Bad form! Should stand alone!)
		assertEquals(10, calculator.divide(10, 1));
	}

	/**
	 * What about when you want the assertThrows to fail?  Catch the AssertionFailedError!
	 * Or, better yet, don't be a nimrod and write an assertThrows statement in the first place.
	 */
	@Test
	void divide_When15DividedBy3_ThenNoException() {

		assertThrows(AssertionFailedError.class, () -> {
			// ArithmeticException not thrown, so assertThrows threw an AssertionFailedError.
			assertThrows(ArithmeticException.class, () -> {
				assertEquals(5, calculator.divide(15, 3));
			});
		});
		
		// This is the net effect of the double assertThrows above!
		assertEquals(5, calculator.divide(15, 3));
	}

}
