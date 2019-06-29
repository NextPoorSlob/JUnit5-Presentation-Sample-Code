/**
 * 
 */
package com.nextpoorslob.junit5.a000.service;

/**
 * Implements a Calculator for Integers.  Note that a null is considered a zero.
 * @author stephen
 *
 */
public class IntegerCalculator implements Calculator<Integer> {

	public Integer add(Integer addendLeft, Integer addendRight) {
		
		return (addendLeft != null ? addendLeft : 0)
				+ (addendRight != null ? addendRight : 0);
	}

	public Integer subtract(Integer minuend, Integer subtrahend) {
		
		return (minuend != null ? minuend : 0)
				+ (subtrahend != null ? subtrahend : 0);
	}

}
