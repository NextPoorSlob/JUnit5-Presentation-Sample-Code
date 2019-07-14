/**
 * 
 */
package com.nextpoorslob.tagsandfilters;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * This class uses the EndToEndTest tag to mark it as, well, an end-to-end test.  This would probably be
 * a slow test which you wouldn't want to run during normal development.
 * @author stephen
 *
 */
class UserAcceptanceTest {

	@EndToEndTest
	void testAReallyLongProcess() {
		fail("This test should not run during the normal development cycle.");
	}

	@TestOnWindows
	void testSomethingShortOnWindows() {
		System.out.println("This does not take anytime at all and runs on Windows,  only.");
	}

	@Test
	@EnabledOnOs(OS.MAC)
	void testSomethingShortOnMac() {
		System.out.println("This does not take anytime at all and runs on Mac, only");
	}

}
