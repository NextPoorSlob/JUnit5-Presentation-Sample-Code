/**
 * 
 */
package com.nextpoorslob.junit5.b100.service;

import java.util.stream.Stream;

/**
 * You can use static methods in external classes as @MethodSource providers.
 * 
 * @author Stephen Gelman
 *
 */
class ExternalDataMethodSourceProvider {

	static Stream<String> curses() {
		return Stream.of(
				"Dag nabbit!",
				"Fiddlesticks!",
				"Poppycock!",
				"Bite me in a naughty place"
			);
	}
}
