package com.nextpoorslob.junit5.b100.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests with the data and the test located with each other. Note that only one
 * argument is allowed here.  These are tests either adapted or stolen outright
 * from the JUnit 5 Users Guide.
 * 
 * @author Stephen Gelman
 *
 */
public class ColocatedParameterizedTest {

	/**
	 * Simple test with a group of numbers. This could have been done as a
	 * RepeatedTest.
	 * 
	 * @param argument the integer to test.
	 */
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	void testWithValueSource(int argument) {
		assertTrue(argument > 0 && argument < 4);
	}

	/**
	 * Getting a little fancier, and including a check for nulls and empty String.
	 * 
	 * @param candidate a String to check for being a palindrome.
	 */
	@ParameterizedTest
	@NullSource
	@EmptySource
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromes(String candidate) {
		assertTrue(StringInfo.isPalindrome(candidate));
	}

	/**
	 * Check for a null of empty String. Note the @NullSource and the @EmptySource
	 * annotations are smooshed together as @NullAndEmptySource. And note that this
	 * tag is for null or empty SOURCEs, not strings!
	 * 
	 * @param text the text to check for null or empty condition.
	 */
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { " ", " ", "\t", "\n" })
	void nullEmptyAndBlankStrings(String text) {
		assertTrue(text == null || text.trim().isEmpty());
	}

	/**
	 * You can use an enumerator to supply your test values.
	 * 
	 * @param timeUnit checked for existence!
	 */
	@ParameterizedTest
	@EnumSource(TimeUnit.class)
	void testWithEnumSource(TimeUnit timeUnit) {
		assertNotNull(timeUnit);
	}

	/**
	 * You can use an enumerator to supply your test values, excluding unwanted
	 * values.
	 * 
	 * @param timeUnit checked for existence!
	 */
	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, mode = Mode.EXCLUDE, names = { "DAYS", "HOURS" })
	void testWithEnumSourceExclude(TimeUnit timeUnit) {
		assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
		assertTrue(timeUnit.name().length() > 5);
	}

	/**
	 * You can use an enumerator to supply your test values, including only wanted
	 * values with a regular expression.
	 * 
	 * @param timeUnit checked for existence!
	 */
	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, mode = Mode.MATCH_ALL, names = "^(M|N).+SECONDS$")
	void testWithEnumSourceRegex(TimeUnit timeUnit) {
		String name = timeUnit.name();
		assertTrue(name.startsWith("M") || name.startsWith("N"));
		assertTrue(name.endsWith("SECONDS"));
	}

	/**
	 * You can supply multiple arguments with test data inline using the @CsvSource annotation. 
	 */
	@ParameterizedTest
	@CsvSource({ 
		"apple, 1, 36",
		"banana, 2, 51",
		"potato, 3, 78"
	})
	void testWithCsvSource(String fruit, int rank, int glycemicIndex) {
		assertNotNull(fruit);
		assertNotEquals(0, rank);
		assertTrue(glycemicIndex < 100);
	}
	

}
