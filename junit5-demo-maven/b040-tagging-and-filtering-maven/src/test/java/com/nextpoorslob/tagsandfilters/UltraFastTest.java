/**
 * 
 */
package com.nextpoorslob.tagsandfilters;

import org.junit.jupiter.api.Test;

/**
 * This is a very fast test.  You can tell by its tag.
 * @author stephen
 *
 */
class UltraFastTest {

	@Test  // Test annotation still needed because the Flash annotation doesn't include it.
	@Flash
	void testSomethingVeryQuickly() {
		System.out.println("Whoosh!");
	}

}
