package com.example.demo.servicetest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dao.AcntsDao;
import com.example.demo.dao.CurrencyDao;
import com.example.demo.entity.Acnts;
import com.example.demo.entity.AcntsId;
import com.example.demo.entity.Clients;
import com.example.demo.entity.Currency;
import com.example.demo.entity.Product;
import com.example.demo.service.AcntsService;
import com.example.demo.service.CurrencyService;

@ExtendWith(MockitoExtension.class)
public class CurrencyServicetest {
	@InjectMocks
	private CurrencyService currService;
	
	@Mock
	private CurrencyDao currencyDao;
	
	private Currency currency;
	
	@DisplayName("JUnit test for save Users method") 
	
	 @BeforeEach
	    public void setup(){
		  currency=Currency.builder().currCode("SCR").currName("Seycels rupee").
				  currShortNotation("Rupees").currIsoCode(690).currWithHoldTaxReqd(true).currEntdBy("LSIL").currEntdOn(LocalDateTime.now())
				  .build();
	}
	
	@DisplayName("JUnit test for check account positive") 
	@Test
	public void posCheck() throws Exception
	{
		//given
		String currCode="SCR";
		given(currencyDao.findById(currCode)).willReturn(Optional.of(currency));
		
       
       //when
       
       boolean res = currService.checkCurr(currCode);
      
      assertTrue(res);
		
	}
	
	@DisplayName("JUnit test for check account negative") 
	@Test
	public void negCheck() throws Exception
	{
		//given
		String currCode="SCR";
		given(currencyDao.findById(currCode)).willReturn(Optional.empty());
		
       
       //when
       
       boolean res = currService.checkCurr(currCode);
      
      assertTrue(res);
		
	}


}
