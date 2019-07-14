/**
 * 
 */
package com.nextpoorslob.tagsandfilters;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;;

@Retention(RUNTIME)
@Target(METHOD)
@Test
@EnabledOnOs(OS.WINDOWS)
/**
 * Run method as a test but only on a Windows Machine.
 * 
 * @author Stephen Gelman
 *
 */
public @interface TestOnWindows {
}
