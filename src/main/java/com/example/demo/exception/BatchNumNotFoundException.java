package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Batch Not Generated")
public class BatchNumNotFoundException extends RuntimeException {
	
	 public BatchNumNotFoundException() {
	    }

	    public BatchNumNotFoundException(String message) {
	        super(message);
	    }

}
