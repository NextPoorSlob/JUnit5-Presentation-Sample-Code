/**
 * 
 */
package com.nextpoorslob.junit5.b010.service;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.nextpoorslob.junit5.b010.support.DisplayNameGeneratorCamelCaseToWords;

/**
 * This examples shows using a custom DisplayNameGenerator.  This example does not
 * need to be nested, a concept I'll go into later, but it helps keep the example
 * in one source file.
 * 
 * @author stephen
 *
 */
@DisplayNameGeneration(DisplayNameGeneratorCamelCaseToWords.class)
class DisplayNamesGeneratedCustomTest {

	@Test
	void test_with_InjectionOfDependency(TestInfo testInfo) {
		System.out.println("\"" + testInfo.getDisplayName() + "\" <-- This name came from a IoD!");
	}

	@Test
	@DisplayName("I'm a Yankee Doodle Dandy!")
	void test_with_overriden_name(TestInfo testInfo) {
		System.out.println("test_with_overriden_name: \"" + testInfo.getDisplayName() + "\" <-- Name was overridden!");
	}

	@Nested
	@DisplayNameGeneration(Reverser.class)
	class InnerClass {
		@Test
		void am_I_Backwards() {
			System.out.println("Removed undscores and reversed the name.");
		}

		@Test
		void madam_im_adam() {
			System.out.println("Removed undscores and reversed the name.");
		}

	}

	static class Reverser extends DisplayNameGenerator.ReplaceUnderscores {
		@Override
		public String generateDisplayNameForClass(Class<?> testClass) {
			return super.generateDisplayNameForClass(testClass);
		}

		@Override
		public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
			return super.generateDisplayNameForNestedClass(nestedClass);
		}

		@Override
		public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod){
			String name = testClass.getSimpleName() + ' ' + testMethod.getName(); 
			StringBuilder nameToReverse = new StringBuilder(name.replace('_',' ' ));
			return nameToReverse.reverse().toString();
		}
	}

}