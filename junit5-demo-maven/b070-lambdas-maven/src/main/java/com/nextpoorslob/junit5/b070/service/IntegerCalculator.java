/**
 * 
 */
package com.nextpoorslob.junit5.b070.service;

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
				- (subtrahend != null ? subtrahend : 0);
	}

	public Integer divide(Integer dividend, Integer divisor) {
		return (dividend != null ? dividend : 0)
				/ (divisor != null ? divisor : 0);
	}
	
	@Override
	public Integer multiply(Integer multiplier, Integer multiplicand) {
		return (multiplier != null ? multiplier : 0)
				* (multiplicand != null ? multiplicand : 0);
	}
}
