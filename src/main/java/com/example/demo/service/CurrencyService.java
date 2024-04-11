package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dao.CurrencyDao;
import com.example.demo.entity.Acnts;
import com.example.demo.entity.AcntsId;
import com.example.demo.entity.Currency;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.exception.InvalidCurrencyException;

@Service
public class CurrencyService {
	
	private CurrencyDao currencyDao;
	
	public CurrencyService(CurrencyDao currencyDao) {
		this.currencyDao=currencyDao;
	}
	
	public Currency saveCurrency(Currency curr) {
		return this.currencyDao.save(curr);
	}
	
	public void delCurrency(String currId) {
		this.currencyDao.deleteById(currId);
	}
	public List<Currency> fetchAllCurr(){
		return this.currencyDao.findAll().stream().map(obj->{
			return Currency.builder().currCode(obj.getCurrCode()).currName(obj.getCurrName())
					.build();
		}).toList();
	}
	
	public boolean checkCurr(String currCode){
		Currency currObj=this.currencyDao.findById(currCode).orElseThrow(()->new InvalidCurrencyException("Invalid Currency"));
	    return true;
	}

}
