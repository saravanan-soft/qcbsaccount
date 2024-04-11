package com.example.demo.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcntBalId {

	   @NotNull(message="acntsAccountNumber should not be null")
	   @NotEmpty(message="acntsAccountNumber should not be empty")
	   @Length(max=14,message="acntsAccountNumber length exist")
	   private String acntsBalAccountNumber;
	   @NotNull(message="acntsBalCurrCode should not be null")
	  @Length(max=3,message="acntsCurrCode length exist") 
	  private String acntsBalCurrCode;

}
