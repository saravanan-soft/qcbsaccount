package com.example.demo.servicetest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dao.AcntsDao;
import com.example.demo.entity.Acnts;
import com.example.demo.entity.AcntsId;
import com.example.demo.entity.Clients;
import com.example.demo.entity.Product;
import com.example.demo.service.AcntsService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AcntsServicetest {

	@InjectMocks
	private AcntsService acntService;
	
	@Mock
	private AcntsDao acntsDao;
	
	private AcntsId acntsId;
	 private  Clients client;
	  private  Product product;
	  private  Acnts acnt;
	
	@DisplayName("JUnit test for save Users method") 
	
	 @BeforeEach
	    public void setup(){
		acntsId=new AcntsId("1133713498",Integer.valueOf(100));
		 client=Clients.builder().clientsCode(175).clients_type_flg('I').clientsHomeBrnCode(100).
				 clientsTitleCode("Mrs").clientsName("Linda aglae").clientsAlphaId("").clientsConstCode(Long. valueOf(17)).clientsAddr1("Belvedere").clientsAddr2("Mahe").clientsLocnCode("1").clientsCustCatg("MIG").
				 clientsSegmentCode("MIG").clientsBusdivnCode("99").clientsOpeningDate(LocalDate.now()).
				 clientsGroupCode("").cleintsEntdBy("LSIL").clientsEntdOn(LocalDateTime.now())
				 .build();
		  product=Product.builder().productCode(Long.valueOf(35)).productName("SDR Holding account").
				  productConcName("SDR Hold Acc").productAlpha("SDR").productGroupCode("01").productClass('F').product_glacc_code(3500).productEntdBy("LSIL").productEntdOn(LocalDateTime.now()).
				  build();
		  acnt=Acnts.builder().acntsId(acntsId).products(product).clients(client).acntsAcType("161").
				  acntsSchemeCode("").acntsOpeningDate(LocalDate.now()).acntsAcName1("CBS - Bankers Cheque Transit Account -SCR").
				  acntsShortName("CBSBankers Chq Transit ac").acntsAcAddr1("Central bank building").acnts_locn_code("1").acnts_curr_code("SCR").
				  acnts_glacc_code("1600").acntsPassbkReqd(false).acntsAtmOpern(false).acntsEntdBy("LSIL").acntsEntdOn(LocalDateTime.now()).build();
				  
	}
	
	@DisplayName("JUnit test for check account positive") 
	@Test
	public void posCheck() throws Exception
	{
		//given
		AcntsId acntsIdnew= new AcntsId("1133713498",Integer.valueOf(100));
		given(acntsDao.findById(acntsId)).willReturn(Optional.of(acnt));
		
		System.out.println(acntsDao);
        System.out.println(acntService);
        
        //when
        
        boolean res = acntService.checkAcc(acntsIdnew);
       
       assertTrue(res);
		
	}
	
	@DisplayName("JUnit test for check account negative") 
	@Test
	public void negCheck() throws Exception
	{
		//given
		AcntsId acntsIdnew= new AcntsId("1133713498",Integer.valueOf(100));
		given(acntsDao.findById(acntsId)).willReturn(Optional.empty());
		
		System.out.println(acntsDao);
        System.out.println(acntService);
        
        //when
        
        boolean res = acntService.checkAcc(acntsIdnew);
       
       assertTrue(res);
		
	}

}
