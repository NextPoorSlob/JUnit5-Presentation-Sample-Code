/**
 * 
 */
package com.nextpoorslob.junit5.b010.lifecylce;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Illustrates the JUnit life-cycle.
 * @author stephen
 *
 */
class LifeCycleDemoATopLevelOnlyTest {

	@BeforeAll
	static void beforeAllTopLevel() {
		System.out.println("Top-level Before All");
	}
	
	@AfterAll
	static void afterAllTopLevel() {
		System.out.println("Top-level After All");
	}
	
	@AfterEach
	void afterEachTopLevel() {
		System.out.println("Top-level After Each");
	}
	
	@BeforeEach
	void beforeEachTopLevel() {
		System.out.println("Top-level Before Each");
	}
	
	@Test
	void test1TopLevel() {
		System.out.println("Top-level Test1");
	}

	@Test
	void test2TopLevel() {
		System.out.println("Top-level Test2");
	}
	
}
