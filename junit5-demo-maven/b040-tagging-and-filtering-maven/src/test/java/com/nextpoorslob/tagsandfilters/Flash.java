/**
 * 
 */
package com.nextpoorslob.tagsandfilters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;

/**
 * Defines a custom tag to signify something that happens very quickly.
 * @author stephen
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Tag("Flash")
//  Test annotation NOT included on this tag --> @Test
public @interface Flash {
}
