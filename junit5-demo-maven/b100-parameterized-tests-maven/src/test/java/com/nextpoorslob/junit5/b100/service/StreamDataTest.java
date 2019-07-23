/**
 * 
 */
package com.nextpoorslob.junit5.b100.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Tests with the data sourced by streams. Note that more than one argument is
 * allowed here. These are tests either adapted or stolen outright from the
 * JUnit 5 Users Guide.
 * 
 * @author Stephen Gelman
 *
 */
public class StreamDataTest {

	/**
	 * You can use a stream as the method source. Anything Java can convert into a
	 * stream can be used. The factory can be an external static class: you just
	 * have to supply the fully qualified name. For example:
	 * com.nextpoorslob.junit5.b100.service.ParameterizedTestsFromGuideTest#stringFactory
	 * 
	 * @param argument the data to check that it exists.
	 */
	@ParameterizedTest
	@MethodSource("stringFactory")
	void testWithExplicitLocalMethodSource(String argument) {
		assertNotNull(argument);
	}

	/**
	 * Supplies the String stream for the testWithExplicitLocalMethodSource method.
	 * 
	 * @return a stream of Strings.
	 */
	static Stream<String> stringFactory() {
		return Stream.of("apple", "banana");
	}

	// ----------------------------------------------------------------------------------------
	
	/**
	 * Streams for primitive types (DoubleStream, IntStream, and LongStream) are
	 * also supported
	 * 
	 * @param argument an int value
	 */
	@ParameterizedTest
	@MethodSource("intRange")
	void testWithIntRangeMethodSource(int argument) {
		assertNotEquals(9, argument);
	}

	static IntStream intRange() {
		return IntStream.range(0, 20).skip(10);
	}

	// ----------------------------------------------------------------------------------------
	
	@ParameterizedTest
	@MethodSource("stringIntAndListProvider")
	void testWithMultiArgMethodSource(String str, int num, List<String> list) {
		assertEquals(5, str.length());
		assertTrue(num >= 1 && num <= 2);
		assertEquals(2, list.size());
	}

	
	static Stream<Arguments> stringIntAndListProvider() {
		return Stream.of(
				Arguments.of("apple", 1, Arrays.asList("a", "b")),
				Arguments.of("lemon", 2, Arrays.asList("x", "y")));
	}

}
