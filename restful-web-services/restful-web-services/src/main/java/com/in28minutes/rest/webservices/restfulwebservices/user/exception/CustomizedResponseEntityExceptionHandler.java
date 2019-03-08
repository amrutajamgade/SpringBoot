package com.in28minutes.rest.webservices.restfulwebservices.user.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	/***
	 * Exception handling for Exception.class 
	 * HttpStatus.INTERNAL_SERVER_ERROR
	 * */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(
			Exception ex,  WebRequest request) {

		//(Date timestamp, String error_message, String error_details, String error_code)
		ExceptionResponse objExpRes =  new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false), "ERROR-001" );
		
		return new ResponseEntity(objExpRes, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/***
	 * Exception handling for UserNotFoundExcepetion.class 
	 * HttpStatus.NOT_FOUND
	 * */
	@ExceptionHandler(UserNotFoundExcepetion.class)
	public final ResponseEntity<Object> handleUserNotFoundException(
			UserNotFoundExcepetion ex,  WebRequest request) {

		//(Date timestamp, String error_message, String error_details, String error_code)
		ExceptionResponse objExpRes =  new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false), "ERROR-007" );
		
		return new ResponseEntity(objExpRes, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		//(Date timestamp, String error_message, String error_details, String error_code)
		ExceptionResponse objExpRes =  new ExceptionResponse(new Date(), "Input Validation Failed", ex.getBindingResult().toString(), "ERROR-005" );
		
		return new ResponseEntity(objExpRes, HttpStatus.BAD_REQUEST);	
		
	}

}
