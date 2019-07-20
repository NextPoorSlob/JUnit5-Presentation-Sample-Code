/**
 * 
 */
package com.nextpoorslob.junit5.b100.service;

/**
 * Expose additional information about a String.
 * 
 * @author Stephen Gelman
 *
 */
public class StringInfo {

	/**
	 * Is the string the same forward as backwards, ignoring case. A null or empty
	 * string returns true.
	 * 
	 * @param string the String to test.
	 * @return true if string is a palindrome.
	 */
	public static boolean isPalindrome(String string) {
		if (string == null || string.isEmpty()) {
			return true;
		}
		
		StringBuilder test = new StringBuilder(string);
		return (string.equalsIgnoreCase(test.reverse().toString())); 

	}
}
