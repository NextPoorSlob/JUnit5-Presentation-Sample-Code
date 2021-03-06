/**
 * 
 */
package com.nextpoorslob.tagsandfilters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * Defines a custom tag to signify an end-to-end test.
 * @author stephen
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Tag("EndToEndTest")
@Test
@EnabledOnOs(OS.WINDOWS)
public @interface EndToEndTest {
}
