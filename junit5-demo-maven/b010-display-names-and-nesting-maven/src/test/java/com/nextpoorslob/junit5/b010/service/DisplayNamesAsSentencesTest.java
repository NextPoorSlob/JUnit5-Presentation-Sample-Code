/**
 * 
 */
package com.nextpoorslob.junit5.b010.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests showing the basic usage of DisplayNames.
 * 
 * @author Stephen Gelman
 *
 */
class DisplayNamesAsSentencesTest {

	@Test
	@DisplayName("This Is A Test Name In English!  Very Good!")
	void englishName() {
		System.out.println("englishName - This test prints a name as an English sentence.");
	}

	@Test
	@DisplayName("Este es un nombre de prueba en español! ¡Muy bien!")
	void spanishName() {
		System.out.println("spanishName - Esta prueba imprime un nombre como una oración en español.");
	}

	@Test
	@DisplayName("😂😍🎉👍")
	void emojiName() {
		System.out.println("emojiName - This test prints a name as unintelligble mishmash: 😂😍🎉👍");
	}
}
