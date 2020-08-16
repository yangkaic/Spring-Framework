package com.luv2code.springdemo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luv2code.springdemo.error.response.ErrorResponse;
import com.luv2code.springdemo.exception.BookNotFoundException;
import com.luv2code.springdemo.exception.StudentNotFoundException;

@ControllerAdvice
public class GlobalRestExceptionHandler {
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(StudentNotFoundException exc) {
		System.out.println("Inside GlobalRestExceptionHandler.handleException(StudentNotFoundException exc)");
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(BookNotFoundException exc) {
		
		System.out.println("Inside GlobalRestExceptionHandler.handleException(BookNotFoundException exc)");
		
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exc) {
		System.out.println("Inside GlobalRestExceptionHandler.handleException(Exception exc)");
		
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
		
	}

}
