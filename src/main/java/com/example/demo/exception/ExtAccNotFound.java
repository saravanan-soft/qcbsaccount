package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Ext Acc Not Found")
public class ExtAccNotFound extends RuntimeException{
	
	 public ExtAccNotFound() {
	    }

	    public ExtAccNotFound(String message) {
	        super(message);
	    }
}