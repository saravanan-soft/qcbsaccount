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
public class EFTBANKCURRPARAM {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String eftBankCode; // eft_bank_code VARCHAR2(6) not null
    private String eftCurrencyCode; // eft_curr_code VARCHAR2(3) not null
    private String eftCreditGlAccess; // eft_credit_gl_access VARCHAR2(15)
    private String eftDebitGlAccess; // eft_dedit_gl_access VARCHAR2(15)
    private String enteredBy; // eft_entd_by VARCHAR2(8)
    private LocalDate enteredOn; // eft_entd_on DATE
    private String lastModifiedBy; // eft_last_mod_by VARCHAR2(8)
    private LocalDate lastModifiedOn; // eft_last_mod_on DATE
    private String authorizedBy; // eft_auth_by VARCHAR2(8)
    private LocalDate authorizedOn; // eft_auth_on DATE
    private String mainKey; // tba_main_key VARCHAR2(25)

}
