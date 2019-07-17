/**
 * 
 */
package com.nextpoorslob.junit.b080;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

/**
 * Riffed upon from the TestReporterDemo class in the JUnit 5 Users Guide.
 * 
 * @author Stephen Gelman
 *
 */
public class TestReporterTest {

	@Test
	void reportSingleValue(TestReporter testReporter) {
		testReporter.publishEntry("a status message");
	}

	@Test
	void reportKeyValuePair(TestReporter testReporter) {
		testReporter.publishEntry("a key", "a value");
	}

	@Test
	void reportMultipleKeyValuePairs(TestReporter testReporter) {
		Map<String, String> values = new HashMap<>();
		values.put("user name", "dk38");
		values.put("award year", "1974");
		testReporter.publishEntry(values);
	}
}
