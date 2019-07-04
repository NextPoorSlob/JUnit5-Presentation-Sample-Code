/**
 * 
 */
package com.nextpoorslob.junit5.a030.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nextpoorslob.junit5.a030.service.Calculator;

/**
 * Implements a web service for a calculator.
 * 
 * @author Stephen Gelman
 *
 */
@RestController
public class IntegerCalculatorController {

	private Calculator<Integer> calculator;

	@Autowired
	public IntegerCalculatorController(Calculator<Integer> calculator) {
		this.calculator = calculator;
	}

	/**
	 * Add two integers. Nobody iin their right mind would do it this way!
	 * 
	 * @param leftAddend  the Integer on the left.
	 * @param rightAddend the Integer on the right.
	 * @return a response object contains the sum of the addends.
	 */
	@GetMapping("/add/{leftAddend}/{rightAddend}")
	public ResponseEntity<Integer> add(@PathVariable("leftAddend") Integer leftAddend,
			@PathVariable("rightAddend") Integer rightAddend) {
		return ResponseEntity.ok(calculator.add(leftAddend, rightAddend));
	}

}
