package com.example.demo.controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controller.CurrencyController;
import com.example.demo.entity.Acnts;
import com.example.demo.entity.Clients;
import com.example.demo.entity.Currency;
import com.example.demo.service.AcntsService;
import com.example.demo.service.CurrencyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@WebMvcTest(CurrencyController.class)
public class CurrencyControllerTest {
	
	 @Autowired
	  private MockMvc mvc;
	  
	  @MockBean
	  CurrencyService currencyService;
	  
	  private static Currency currency;
	  
	  @BeforeAll
	  public static void setUpBeforeClass() {
		  currency=Currency.builder().currCode("SCR").currName("Seycels rupee").
				  currShortNotation("Rupees").currIsoCode(690).currWithHoldTaxReqd(true).currEntdBy("LSIL").currEntdOn(LocalDateTime.now())
				  .build();
		  
	  }
	  
	  @Test
	  public void createCurrAPI() throws Exception 
	  {
		  given(currencyService.saveCurrency(any(Currency.class)))
	        .willAnswer((invocation)-> invocation.getArgument(0));  
		  
	    mvc.perform( MockMvcRequestBuilders
	  	      .post("/api/v1/curr/create")
	  	      .content(asJsonString(currency))
	  	      .contentType(MediaType.APPLICATION_JSON)
	  	      .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isCreated())
	        .andExpect(MockMvcResultMatchers.jsonPath("$.currCode").exists());
	  }
	   
	  public static String asJsonString(final Object obj) {
	      try {
	    	  
	    	  return new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(obj);
	      } catch (Exception e) {
	          throw new RuntimeException(e);
	      }
	  }

}
