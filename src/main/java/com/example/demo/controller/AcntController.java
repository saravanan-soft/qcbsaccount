package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.demo.entity.BankCode;
import com.example.demo.entity.EFTBANKCURRPARAM;
import com.example.demo.entity.EFTMAPBANK;
import com.example.demo.service.AcntsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/acnt")
public class AcntController {
	
	private AcntsService acntService;
	
	public AcntController(AcntsService acntService) {
		this.acntService=acntService;
	}
	
	private static final Logger acntCtlLogger = LoggerFactory.getLogger(AcntController.class);
	
	@PostMapping("/create")
	public ResponseEntity<?> createAcnt(@Valid @RequestBody Acnts acnt){
		return new ResponseEntity<>(this.acntService.saveAcnts(acnt),HttpStatus.CREATED);
	}
	
	@GetMapping("/check")
	public ResponseEntity<?> chkAcnt(@Valid @RequestBody AcntsId acntId){
		return new ResponseEntity<>(this.acntService.checkAcc(acntId),HttpStatus.OK);
	}
	
	@GetMapping("/getEftMapBank")
	public ResponseEntity<?> getEftMapBank(@RequestParam int eftCode ){
		acntCtlLogger.info("Step 5");
		return new ResponseEntity<>(this.acntService.getEftMapBank(eftCode),HttpStatus.OK);
	}
	
	@GetMapping("/getBankCode")
	public ResponseEntity<?> getBankCode(@RequestParam String bankCode){
		return new ResponseEntity<>(this.acntService.checkBankCode(bankCode),HttpStatus.OK);
	}
	
	@GetMapping("/getAcntDetails")
	public ResponseEntity<?> getAcntDetails(@RequestParam String acNum){
		return new ResponseEntity<>(this.acntService.getAcntsDetails(acNum),HttpStatus.OK);
	}
	
	//getExternalAcnum
	
	@GetMapping("/getExtAcnum")
	public ResponseEntity<?> getExternalAcnum(@RequestParam String bankCode,@RequestParam String currCode){
		return new ResponseEntity<>(this.acntService.getExternalAcnum(bankCode, currCode),HttpStatus.OK);
	}
	
	@PostMapping("/eftmapbank")
	public ResponseEntity<?> crateEftMapBank(@RequestBody EFTMAPBANK eftMapBank){
		return new ResponseEntity<>(this.acntService.createEftMapBank(eftMapBank),HttpStatus.CREATED);
	}
	
	//createBankCode
	
	@PostMapping("/bankCode")
	public ResponseEntity<?> createBankCode(@RequestBody BankCode bankCode){
		return new ResponseEntity<>(this.acntService.createBankCode(bankCode),HttpStatus.CREATED);
	}
	
	//createEftBamkCur
	
	@PostMapping("/eftBankCur")
	public ResponseEntity<?> createBankCur(@RequestBody EFTBANKCURRPARAM eftBANKCURRPARAM){
		return new ResponseEntity<>(this.acntService.createEftBamkCur(eftBANKCURRPARAM),HttpStatus.CREATED);
	}
}

