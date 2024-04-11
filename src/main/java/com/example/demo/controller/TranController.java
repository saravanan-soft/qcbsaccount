package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Currency;
import com.example.demo.service.CurrencyService;
import com.example.demo.service.TranService;

import dto.PostDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tran")
public class TranController {
	
	private TranService tranService;
	
	public TranController(TranService tranService) {
		this.tranService=tranService;
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> postTran(@RequestBody  List<PostDto> postDto){
		int a=10;
		return new ResponseEntity<>(this.tranService.postTran(postDto),HttpStatus.CREATED);
	}

	
}
