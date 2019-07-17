/**
 * 
 */
package com.nextpoorslob.junit.b080;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * Riffed upon from the TestInfoDemo class in the JUnit 5 Users Guide.
 * 
 * @author Stephen Gelman
 *
 */
@DisplayName("TestInfo Demo")
public class TestInfoDemo {

	TestInfoDemo(TestInfo testInfo) {
		assertEquals("TestInfo Demo", testInfo.getDisplayName());
	}

	@BeforeEach
	void init(TestInfo testInfo) {
		String displayName = testInfo.getDisplayName();
		assertTrue(displayName.equals("TEST 1") || displayName.equals("test2(TestInfo)"));
	}

	@Test
	@DisplayName("TEST 1")
	@Flash
	void test1(TestInfo testInfo) {
		assertEquals("TEST 1", testInfo.getDisplayName());
		assertTrue(testInfo.getTags().contains("Flash"));
	}

	@Test
	void test2(TestInfo testInfo) {
		assertEquals("test2(TestInfo)", testInfo.getDisplayName());
		assertFalse(testInfo.getTags().contains("Flash"));
	}

}
