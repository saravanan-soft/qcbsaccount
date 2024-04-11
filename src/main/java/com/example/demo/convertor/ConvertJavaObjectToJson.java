package com.example.demo.convertor;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.demo.entity.Acnts;
import com.example.demo.entity.AcntsId;
import com.example.demo.entity.Clients;
import com.example.demo.entity.Currency;
import com.example.demo.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ConvertJavaObjectToJson {
	
	public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
       // Acnts acnt =newAcnts();
        Currency  currency=newCurr();
        try {
        	//mapper.registerModule(new JavaTimeModule()).writeValueAsString(acnt);
        	mapper.registerModule(new JavaTimeModule()).writeValueAsString(currency);
           // mapper.writeValue(new File("acnt.json"), acnt);
          // String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(acnt);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(currency);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Acnts newAcnts() {
    	AcntsId acntid= new AcntsId("1133713498",Integer.valueOf(100));
    	Clients client=Clients.builder().clientsCode(175).clients_type_flg('I').clientsHomeBrnCode(100).
				 clientsTitleCode("Mrs").clientsName("Linda aglae").clientsAlphaId("").clientsConstCode(Long. valueOf(17)).clientsAddr1("Belvedere").clientsAddr2("Mahe").clientsLocnCode("1").clientsCustCatg("MIG").
				 clientsSegmentCode("MIG").clientsBusdivnCode("99").clientsOpeningDate(LocalDate.now()).
				 clientsGroupCode("").cleintsEntdBy("LSIL").clientsEntdOn(LocalDateTime.now())
				 .build();
    	Product product=Product.builder().productCode(Long.valueOf(35)).productName("SDR Holding account").
				  productConcName("SDR Hold Acc").productAlpha("SDR").productGroupCode("01").productClass('F').product_glacc_code(3500).productEntdBy("LSIL").productEntdOn(LocalDateTime.now()).
				  build();
    	Acnts acnt=Acnts.builder().acntsId(acntid).products(product).clients(client).acntsAcType("161").
				  acntsSchemeCode("").acntsOpeningDate(LocalDate.now()).acntsAcName1("CBS - Bankers Cheque Transit Account -SCR").
				  acntsShortName("CBSBankers Chq Transit ac").acntsAcAddr1("Central bank building").acnts_locn_code("1").acnts_curr_code("SCR").
				  acnts_glacc_code("1600").acntsPassbkReqd(false).acntsAtmOpern(false).acntsEntdBy("LSIL").acntsEntdOn(LocalDateTime.now()).build();
				  
    	Currency  currency=Currency.builder().currCode("SCR").currName("Seycels rupee").
				  currShortNotation("Rupees").currIsoCode(690).currWithHoldTaxReqd(true).currEntdBy("LSIL").currEntdOn(LocalDateTime.now())
				  .build();		
     

      

        return acnt;

    }
    
    
    private static Currency newCurr() {
    
    	Currency  currency=Currency.builder().currCode("SCR").currName("Seycels rupee").
				  currShortNotation("Rupees").currIsoCode(690).currWithHoldTaxReqd(true).currEntdBy("LSIL").currEntdOn(LocalDateTime.now())
				  .build();		
     

      

        return currency;

    }
}
