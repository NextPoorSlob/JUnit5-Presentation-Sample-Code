/**
 * 
 */
package com.nextpoorslob.junit5.b060.service;

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
	 * Calculates the quotient of the dividend divided by the divisor.
	 * 
	 * @param dividend the datum divided up.
	 * @param divisor the datum dividing up the dividend.
	 * @return the number of times the divisor goes in the dividend.
	 */
	T divide(T dividend, T divisor);

}
