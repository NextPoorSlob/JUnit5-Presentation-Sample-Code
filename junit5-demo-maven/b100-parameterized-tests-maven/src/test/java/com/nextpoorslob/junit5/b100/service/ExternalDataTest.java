/**
 * 
 */
package com.nextpoorslob.junit5.b100.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * These tests showing the use of Comma-Separated Values are adapted from the
 * JUnit 5 Users Guide.
 * 
 * @author Stephen Gelman
 *
 */
public class ExternalDataTest {

	@ParameterizedTest
	@MethodSource("com.nextpoorslob.junit5.b100.service.ExternalDataMethodSourceProvider#curses")
	void testWithExternalMethodSource(String curses) {
		assertNotNull(curses);
	}

	/**
	 * Use an external file on the classpath (think src/test/resources).
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/three-column.csv", numLinesToSkip = 1)
	void testWithCsvFileSource(String country, int reference, String continent) {
		assertNotNull(country);
		assertNotEquals(0, reference);
		assertNotNull(continent);
	}
}
