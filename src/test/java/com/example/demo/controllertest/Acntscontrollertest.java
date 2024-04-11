package com.example.demo.controllertest;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.controller.AcntController;
import com.example.demo.entity.Acnts;
import com.example.demo.entity.AcntsId;
import com.example.demo.entity.Clients;
import com.example.demo.entity.Product;
import com.example.demo.service.AcntsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;



@WebMvcTest(AcntController.class)
public class Acntscontrollertest {
	
	  @Autowired
	  private MockMvc mvc;
	  
	  @MockBean
	  AcntsService acntsService;
	  
	  private static Clients client;
	  private static Product product;
	  private static Acnts acnt;
	
	  
	  @BeforeAll
	  public static void setUpBeforeClass() {
		  AcntsId acntid= new AcntsId("1133713498",Integer.valueOf(100));
		 client=Clients.builder().clientsCode(175).clients_type_flg('I').clientsHomeBrnCode(100).
				 clientsTitleCode("Mrs").clientsName("Linda aglae").clientsAlphaId("").clientsConstCode(Long. valueOf(17)).clientsAddr1("Belvedere").clientsAddr2("Mahe").clientsLocnCode("1").clientsCustCatg("MIG").
				 clientsSegmentCode("MIG").clientsBusdivnCode("99").clientsOpeningDate(LocalDate.now()).
				 clientsGroupCode("").cleintsEntdBy("LSIL").clientsEntdOn(LocalDateTime.now())
				 .build();
		  product=Product.builder().productCode(Long.valueOf(35)).productName("SDR Holding account").
				  productConcName("SDR Hold Acc").productAlpha("SDR").productGroupCode("01").productClass('F').product_glacc_code(3500).productEntdBy("LSIL").productEntdOn(LocalDateTime.now()).
				  build();
		  acnt=Acnts.builder().acntsId(acntid).products(product).clients(client).acntsAcType("161").
				  acntsSchemeCode("").acntsOpeningDate(LocalDate.now()).acntsAcName1("CBS - Bankers Cheque Transit Account -SCR").
				  acntsShortName("CBSBankers Chq Transit ac").acntsAcAddr1("Central bank building").acnts_locn_code("1").acnts_curr_code("SCR").
				  acnts_glacc_code("1600").acntsPassbkReqd(false).acntsAtmOpern(false).acntsEntdBy("LSIL").acntsEntdOn(LocalDateTime.now()).build();
				  
				

	    }
	  
	  @Test
	  public void createAcntAPI() throws Exception 
	  {
		  given(acntsService.saveAcnts(any(Acnts.class)))
	        .willAnswer((invocation)-> invocation.getArgument(0));  
		  
	    mvc.perform( MockMvcRequestBuilders
	  	      .post("/api/v1/acnt/create")
	  	      .content(asJsonString(acnt))
	  	      .contentType(MediaType.APPLICATION_JSON)
	  	      .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isCreated())
	        .andExpect(MockMvcResultMatchers.jsonPath("$.acntsId").exists());
	  }
	   
	  public static String asJsonString(final Object obj) {
	      try {
	    	  
	    	  return new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(obj);
	      } catch (Exception e) {
	          throw new RuntimeException(e);
	      }
	  }

}
