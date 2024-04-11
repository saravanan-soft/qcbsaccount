package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankCode {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	 private String bankCode; // bankcd_code VARCHAR2(6) not null
	    private String bankName; // bankcd_name VARCHAR2(50)
	    private String swiftBicCode; // bankcd_swift_bic_code VARCHAR2(12)
	    private char localBank; // bankcd_local_bank CHAR(1) default 0
	    private String bankType; // bankcd_bk_type VARCHAR2(3)
	    private String headquartersCountry; // bankcd_ho_in_cntry VARCHAR2(2)
	    private int micrCode; // bankcd_micr_code NUMBER(6) default 0
	    private char exposureFlag; // bankcd_exposure_flag CHAR(1) default 0
	    private char correspondsBank; // bankcd_corres_bank CHAR(1) default 0
	    private String rtgsIdentifier; // bankcd_rtgs_identifier VARCHAR2(4)
	    private String enteredBy; // bankcd_entd_by VARCHAR2(8) not null
	    private LocalDate enteredOn; // bankcd_entd_on DATE not null
	    private String lastModifiedBy; // bankcd_last_mod_by VARCHAR2(8)
	    private LocalDate lastModifiedOn; // bankcd_last_mod_on DATE
	    private String authorizedBy; // bankcd_auth_by VARCHAR2(8)
	    private LocalDate authorizedOn; // bankcd_auth_on DATE
	    private String mainKey; // tba_main_key VARCHAR2(25)

}
