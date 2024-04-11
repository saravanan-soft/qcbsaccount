package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "EFT bank code Not Found")
public class EFTBankNotFound extends RuntimeException{
	
	 public EFTBankNotFound() {
	    }

	    public EFTBankNotFound(String message) {
	        super(message);
	    }

}
