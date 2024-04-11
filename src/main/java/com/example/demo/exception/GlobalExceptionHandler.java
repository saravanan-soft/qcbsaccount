package com.example.demo.exception;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	 
	  
	  @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
	        List<String> errors = ex.getBindingResult().getFieldErrors()
	                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
	        return new ResponseEntity<>(getErrorsMap(errors), HttpStatus.BAD_REQUEST);
	    }

	    private Map<String, List<String>> getErrorsMap(List<String> errors) {
	        Map<String, List<String>> errorResponse = new HashMap<>();
	        errorResponse.put("errors", errors);
	        return errorResponse;
	    }
	    
	    @ExceptionHandler(AccountNotFoundException.class)
	    public ResponseEntity<?> AccountNotFoundException(AccountNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(InvalidCurrencyException.class)
	    public ResponseEntity<?> InvalidCurrencyException(InvalidCurrencyException ex) {
	    	logger.info(ex.getLocalizedMessage());
	    	return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	    }
	    
	    @ExceptionHandler(BatchNumNotFoundException.class)
	    public ResponseEntity<?> BatchNumNotFoundException(BatchNumNotFoundException ex) {
	    	logger.info(ex.getLocalizedMessage());
	    	return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	    }


}
