/**
 * 
 */
package com.nextpoorslob.junit5.b010.lifecylce;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Illustrates the JUnit life-cycle with nested tests.
 * 
 * @author stephen
 *
 */
class LifeCycleDemoBNestedTest {

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
		System.out.println("+Top-level After Each");
	}

	@BeforeEach
	void beforeEachTopLevel() {
		System.out.println("+Top-level Before Each");
	}

	@Test
	void test1TopLevel() {
		System.out.println("++Top-level Test1");
	}

	@Test
	void test2TopLevel() {
		System.out.println("++Top-level Test2");
	}

	/**
	 * Nested classes do not allow BeforeAll/AfterAll methods because Java does not
	 * permit static members in inner classes. See the NestedGrandchild inner class
	 * of the NestedChild class.
	 * 
	 * @author stephen
	 *
	 */
	@Nested
	class NestedChild {

		@AfterEach
		void afterEachChildLevel() {
			System.out.println("++Child-level After Each");
		}

		@BeforeEach
		void beforeEachChildLevel() {
			System.out.println("++Child-level Before Each");
		}

		@Test
		void test1ChildLevel() {
			System.out.println("+++Child-level Test1");
		}

		@Test
		void test2ChildLevel() {
			System.out.println("+++Child-level Test2");
		}

		@Nested
		@TestInstance(Lifecycle.PER_CLASS)
		class NestedGrandchild {
			@BeforeAll
			void beforeAllGrandchildLevel() {
				System.out.println("+++Grandchild-level Before All");
			}

			@AfterAll
			void afterAllGrandchildLevel() {
				System.out.println("+++Grandchild-level After All");
			}

			@AfterEach
			void afterEachGrandchildLevel() {
				System.out.println("++++Grandchild-level After Each");
			}

			@BeforeEach
			void beforeEachGrandchildLevel() {
				System.out.println("++++Grandchild-level Before Each");
			}

			@Test
			void test1GrandchildLevel() {
				System.out.println("+++++Grandchild-level Test1");
			}

			@Test
			void test2GrandchildLevel() {
				System.out.println("+++++Grandchild-level Test2");
			}

		}

	}
}
