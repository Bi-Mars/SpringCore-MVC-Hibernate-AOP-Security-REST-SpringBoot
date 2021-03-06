package com.luv2code.springdemo.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//Handle Exception Thrown by REST API
@ControllerAdvice
//@RestControllerAdvice --> No need to use @ResponseBody --> No JSON
public class CustomRestExceptionHandler {
	
	//Add an exception handler for CustomerNotFundException
	@ExceptionHandler
	//@ResponseBody --> Converts exception into string
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		
		//create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		//return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // error goes to response's body and status goes to response's header
	}
	
	// Ad another exception handler ... to catch any exception (catch all)
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc){
		
		//create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		//return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); // error goes to response's body and status goes to response's header
	}	

}
