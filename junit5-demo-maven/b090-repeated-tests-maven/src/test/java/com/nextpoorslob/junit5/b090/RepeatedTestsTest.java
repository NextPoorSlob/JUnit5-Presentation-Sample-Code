/**
 * 
 */
package com.nextpoorslob.junit5.b090;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

/**
 * Riffed from the RepeatedTestsDemo in the JUnit 5 Users Guide.
 * 
 * @author Stephen Gelman
 *
 */
public class RepeatedTestsTest {

	@BeforeEach
	void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		int currentRepetition = repetitionInfo.getCurrentRepetition();
		int totalRepetitions = repetitionInfo.getTotalRepetitions();
		String methodName = testInfo.getTestMethod().get().getName();
		System.out.println(String.format("About to execute repetition %d of %d for %s", currentRepetition,
				totalRepetitions, methodName));
	}

	@RepeatedTest(10)
	void repeatedTest() { // ...
	}

	@RepeatedTest(5)
	void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
		assertEquals(5, repetitionInfo.getTotalRepetitions());
	}

	@RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	@DisplayName("Repeat!")
	void customDisplayName(TestInfo testInfo) {
		assertEquals("Repeat! 1/1", testInfo.getDisplayName());
	}

	@RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
	@DisplayName("Details...")
	void customDisplayNameWithLongPattern(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		assertEquals("Details... :: repetition " + repetitionInfo.getCurrentRepetition() + " of "
				+ repetitionInfo.getTotalRepetitions(), testInfo.getDisplayName());
	}

	@RepeatedTest(value = 5, name = "Wiederholung {currentRepetition} von {totalRepetitions}")
	void repeatedTestInGerman() { // ...
	}
}
