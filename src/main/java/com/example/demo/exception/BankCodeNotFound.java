package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Bank code Not Found")
public class BankCodeNotFound extends RuntimeException{
	
	 public BankCodeNotFound() {
	    }

	    public BankCodeNotFound(String message) {
	        super(message);
	    }
}