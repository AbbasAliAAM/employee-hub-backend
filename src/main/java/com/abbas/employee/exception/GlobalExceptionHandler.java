package com.abbas.employee.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<apiError> handleEmployeeNotFound(EmployeeNotFoundException ex) {

		apiError apiError = new apiError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<apiError> handleValidationException(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new LinkedHashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		apiError apiError = new apiError(HttpStatus.BAD_REQUEST.value(), "Validation failed", errors);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<apiError> handleGeneralException(Exception ex) {

	    apiError apiError = new apiError(
	            HttpStatus.INTERNAL_SERVER_ERROR.value(),
	            "Internal server error",
	            null
	    );

	    return ResponseEntity
	            .status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body(apiError);
	}
	
	

}
