package com.example.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name="currency")
public class Currency {
	 @Id
	   @NotNull(message="currCode should not be null")
	   @NotEmpty(message="currCode should not be empty")
	   @Length(max=3,message="currCode length exist")
	 	private String currCode;
	 @Length(max=35,message="currName length exist")
	 private String currName;
	 @Length(max=6,message="currShortNotation length exist")
	  private String currShortNotation;
	 
	 @Digits(integer = 3, fraction = 0,message="currIsoCode length exist")
	  private Integer currIsoCode;
	 @Digits(integer = 3, fraction = 0,message="currWeekHol1 length exist")
	  private Integer currWeekHol1=0; 
	 @Digits(integer = 3, fraction = 0,message="currWeekHol2 length exist")
	  private Integer currWeekHol2=0;
	  private boolean currWithHoldTaxReqd=false;  
	 @NotNull(message="currEntdBy should not be null")
	   @NotEmpty(message="currEntdBy should not be empty")
	   @Length(max=8,message="currEntdBy lengthe exist")
	   private String  currEntdBy;
	   private LocalDateTime currEntdOn;

}
