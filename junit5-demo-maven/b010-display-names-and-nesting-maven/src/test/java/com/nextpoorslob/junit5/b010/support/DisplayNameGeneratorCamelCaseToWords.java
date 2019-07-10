/**
 * 
 */
package com.nextpoorslob.junit5.b010.support;

import java.lang.reflect.Method;

import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

/**
 * Extends the ReplaceUnderscores DisplayNameGenerate to add a space to separate
 * camelCase names to camel Case.
 * 
 * @author Stephen Gelman
 *
 */
public class DisplayNameGeneratorCamelCaseToWords extends ReplaceUnderscores {

	@Override
	public String generateDisplayNameForClass(Class<?> testClass) {
		return super.generateDisplayNameForClass(testClass);
	}

	@Override
	public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
		return super.generateDisplayNameForNestedClass(nestedClass);
	}

	@Override
	public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
		String name = testClass.getSimpleName() + ' ' + testMethod.getName();
		String withoutUnderscores = name.replace('_', ' ');
		return withoutUnderscores.replaceAll(String.format("%s|%s|%s", 
				"(?<=[A-Z])(?=[A-Z][a-z])",
				"(?<=[^A-Z])(?=[A-Z])", 
				"(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
	}

}
