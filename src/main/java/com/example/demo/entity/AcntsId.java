package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcntsId implements Serializable{

	   
	   @NotNull(message="acntsAccountNumber should not be null")
	   @NotEmpty(message="acntsAccountNumber should not be empty")
	   @Length(max=14,message="acntsAccountNumber length exist")
	   private String acntsAccountNumber;
	   @Digits(integer = 6, fraction = 0,message="acntsBrnCode length exist")
	   private Integer acntsBrnCode=0;
	   

}
