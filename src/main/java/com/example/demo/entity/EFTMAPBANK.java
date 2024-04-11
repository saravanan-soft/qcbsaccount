package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="EFTMAPBANK")
@Data
public class EFTMAPBANK {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String mbkCoreCode;
	private Integer mbkEftCode;   
	private String mbkEftShortName;   
	private String MbkEntdBy;  
	
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate mbkEntdOn;    
	private String mbkLastModifiedBy; // VARCHAR2(8)
	private LocalDate mbkLastModifiedOn; // DATE
	private String mbkAuthorizedBy; // VARCHAR2(8)
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate mbkAuthorizedOn; // DATE
	private String tbaMainKey; // VARCHAR2(25)
	private Long mbkEftAccountNumber; // NUMBER(14)
	private String mbkEftGlCode; // VARCHAR2(15)
	private String mbkSeftCode; // VARCHAR2(20)
	

}
