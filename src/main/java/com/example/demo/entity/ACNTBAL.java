package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name="acntbal")
@Data
public class ACNTBAL {
	
	  @EmbeddedId
	  @Valid
	  private AcntBalId acntBalId;
	  private double acntbalAcCurDbSum=0.0; 
	  private double acntbalAcCurCrSum=0.0;  
	  private double acntbalBcCurDbSum=0.0; 
	  private double acntbalBcCurCrSum=0.0;  
	  private double acntbalAcBal=0.0;  
	  private double acntbalBcBal=0.0;
	  private double acntbalAclienAmt=0.0;
	  private double acntbalBclienAmt=0.0;
      private double acntbalAcAmtOnHold=0.0; 
	  private double acntbalMinBalAmt=0.0;

}
