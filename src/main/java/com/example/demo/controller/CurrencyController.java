package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Acnts;
import com.example.demo.entity.AcntsId;
import com.example.demo.entity.Currency;
import com.example.demo.service.AcntsService;
import com.example.demo.service.CurrencyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/curr")
public class CurrencyController {
	
private CurrencyService currService;
	
	public CurrencyController(CurrencyService currService) {
		this.currService=currService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createCurr(@Valid @RequestBody  Currency curr){
		return new ResponseEntity<>(this.currService.saveCurrency(curr),HttpStatus.CREATED);
	}
	
	@GetMapping("/check")
	public ResponseEntity<?> chkAcnt(@RequestParam String currCode){
		return new ResponseEntity<>(this.currService.checkCurr(currCode),HttpStatus.OK);
	}


}
