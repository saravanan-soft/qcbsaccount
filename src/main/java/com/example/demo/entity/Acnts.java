package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Acnts")
@Data
public class Acnts {

	  
	   @Valid
	   @EmbeddedId
	   private AcntsId acntsId;
	   @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	   @JoinColumn(name = "ClientsNum")
	   @Valid
	   private Clients clients;
	
	   @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	   @JoinColumn(name = "acntsProdCode")
	   @Valid
	   private Product products; 
	   @Length(max=5,message="acntsAcType length exist") 
	   private String acntsAcType;
	   @Length(max=6,message="acntsSchemeCode length exist") 
	   private String acntsSchemeCode;
	   
	 
	   private LocalDate acntsOpeningDate;
	   @Length(max=50,message="acntsAcName1 length exist") 
	   private String acntsAcName1;
	   @Length(max=50,message="acntsAcName2 length exist") 
	   private String acntsAcName2;
	   @Length(max=50,message="acntsShortName length exist") 
	  private String acntsShortName;
	   @Length(max=35,message="acntsAcAddr1 length exist") 
		  private String acntsAcAddr1; 
	   @Length(max=35,message="acntsAcAddr2 length exist") 
		  private String acntsAcAddr2;
	   @Length(max=35,message="acntsAcAddr3 length exist") 
		  private String acntsAcAddr3;
	   @Length(max=6,message="acntsLocnCode length exist") 
	  private String acnts_locn_code;
	   @Length(max=3,message="acntsCurrCode length exist") 
	  private String acnts_curr_code;
	   @Length(max=15,message="acntsGlaccCode length exist") 
	  private String acnts_glacc_code;
	  private boolean acntsSalaryAcnt=false;
	  private boolean acntsPassbkReqd;
	  private boolean acntsAtmOpern;
	  private boolean acntsSmsOpern;
	  private boolean acntsDormantAcnt;
	  private LocalDate acntsLastTranDate;
	  private LocalDate acntsIntCalcUpto;
	  private boolean acntsDbFreezed=false;  
	  private boolean acntsCrFreezed=false;
	  private LocalDate acntsAcstUptoDate;
	  private LocalDate acntsClosureDate;
	  @NotNull(message="acntsEntdBy should not be null")
	   @NotEmpty(message="acntsEntdBy should not be empty")
	   @Length(max=8,message="acntsEntdBy lengthe exist")
	   private String acntsEntdBy;
	   @NotNull(message="acntsEntdOn should not be null")
	   private LocalDateTime acntsEntdOn;
	  
}
