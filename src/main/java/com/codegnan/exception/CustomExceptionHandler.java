package com.codegnan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	// Handles invalid Doctor ID errors
	@ExceptionHandler(InvalidDoctorIdException.class)
	public ResponseEntity<ErrorResponse> handleDoctorException(InvalidDoctorIdException e) {

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// Handles invalid Patient ID errors
	@ExceptionHandler(InvalidPatientIdException.class)
	public ResponseEntity<ErrorResponse> handlePatientException(InvalidPatientIdException e) {

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// Handles invalid date format errors
	// 400 means the client sent invalid input
	@ExceptionHandler(InvalidDateFormatException.class)
	public ResponseEntity<ErrorResponse> handleDateException(InvalidDateFormatException e) {

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	// Handles invalid Visit ID errors
	@ExceptionHandler(InvalidVisitIdException.class)
	public ResponseEntity<ErrorResponse> handleVisitException(InvalidVisitIdException e) {

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// Handles any unexpected exception
	// 500 means something went wrong on the server
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGeneralException(Exception e) {

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}