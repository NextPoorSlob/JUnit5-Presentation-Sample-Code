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

	@GetMapping("/add/{leftAddend}/{rightAddend}")
	public ResponseEntity<Integer> add(
			@PathVariable("leftAddend") Integer leftAddend,
			@PathVariable("rightAddend") Integer rightAddend) {
		return ResponseEntity.ok(calculator.add(leftAddend, rightAddend));
	}

}
