package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Primary;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
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
@Table(name="products")
@Data
public class Product {
	
   @Id
   @NotNull(message="product code should not be null")
   @Digits(integer = 4, fraction = 0,message="productCode length exist")
   private Long productCode;
   @Length(max=50,message="productName length exist")
   private String productName;
   @Length(max=15,message="productConcName length exist")
   private String productConcName;
   @Length(max=10,message="productAlpha length exist")
   private String productAlpha;
   @Length(max=6,message="productGroupCode length exist")
   private String productGroupCode;
   private Character productClass;
   private boolean productForDeposits=false;
   private boolean productForLoans=false;
   private boolean productRunAcs=false;
   private boolean productOdFacility=false;
   private boolean productRevolvingFacility=false;
   private boolean productForCallDep=false;
   private boolean productContractAllowed=false;
   private boolean productContractNumGen;
   
   @Digits(integer = 3, fraction = 0,message="productbusdivnCode length exist")
   private Integer productbusdivnCode;
   
   @Digits(integer = 15, fraction = 0,message="product_glacc_code length exist")
   private Integer product_glacc_code;
   private LocalDateTime product_revoked_on;
   @NotNull(message="productEntdBy should not be null")
   @NotEmpty(message="productEntdBy should not be empty")
   @Length(max=8,message="productEntdBy lengthe exist")
   private String  productEntdBy;
  
   private LocalDateTime productEntdOn;
   
   @OneToMany(mappedBy="products" ,cascade=CascadeType.ALL, fetch=FetchType.LAZY)
   private List<Acnts> acnts;
   
}
