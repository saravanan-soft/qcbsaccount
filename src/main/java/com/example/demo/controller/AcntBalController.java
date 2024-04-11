package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ACNTBAL;
import com.example.demo.entity.AcntBalId;
import com.example.demo.entity.Acnts;
import com.example.demo.service.AcntBalService;
import com.example.demo.service.AcntsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/acntbal")
public class AcntBalController {
	
private AcntBalService acntBalService;
	
	public AcntBalController(AcntBalService acntBalService) {
		this.acntBalService=acntBalService;
	}

	@GetMapping("/chkbal")
	public ResponseEntity<?> checkBalance(@RequestParam String acnum,@RequestParam String curr){
		AcntBalId acntBalId=new AcntBalId(acnum,curr);
		return new ResponseEntity<>(acntBalService.getAcntBalAc(acntBalId),HttpStatus.ACCEPTED);
	}
}
