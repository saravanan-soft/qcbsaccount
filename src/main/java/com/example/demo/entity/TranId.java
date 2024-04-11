package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranId {
	
	@Digits(integer = 6, fraction = 0,message="Tran branch length exist")
	private Integer tran_brn_code;
	private LocalDate tran_date_of_tran;
	@Digits(integer = 6, fraction = 0,message="Tran batch length exist")
	private Integer tranBatchNumber;
	private Integer tranBatchSlNumber;
	  

}
