/**
 * 
 */
package com.nextpoorslob.junit5.b070.service;

/**
 * Defines the required calculations for a calculator.
 * 
 * @param <T> type of data used for calculation.
 * 
 * @author stephen
 *
 */
public interface Calculator<T> {

	/**
	 * Adds the two data together.
	 * 
	 * @param addendLeft  datum on the left side of the operation.
	 * @param addendRight datum on the right side off the operation.
	 * @return addendLeft + addendRight
	 */
	T add(T addendLeft, T addendRight);

	/**
	 * Calculates the difference between the minuend and the subtrahend.
	 * 
	 * @param minuend    datum on the left side of the operation.
	 * @param subtrahend datum on the right side off the operation.
	 * @return minuend - subtrahend
	 */
	T subtract(T minuend, T subtrahend);

	/**
	 * Multiplies the
	 * 
	 * @param multiplier   the number to copy.
	 * @param multiplicand the number of times to add the copied number to the
	 *                     result.
	 * @return the muliplier times the multiplicand.
	 */
	Integer multiply(Integer multiplier, Integer multiplicand);

}
