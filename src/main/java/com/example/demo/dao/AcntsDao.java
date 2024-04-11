package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Acnts;
import com.example.demo.entity.AcntsId;


public interface AcntsDao extends JpaRepository<Acnts,AcntsId> {
	
	@Query(value="select MBK_CORE_CODE from eftmapbank where MBK_EFT_CODE =:eftCode",nativeQuery=true)
	public String getEftMapBank(@Param("eftCode")int eftCode);
	
	@Query(value="SELECT COALESCE(count(*), 0) FROM BANK_CODE WHERE BANK_CODE=:bankCode",nativeQuery=true)
	public Integer checkBankCode(@Param("bankCode") String bankCode);
	
	@Query(value="select acnts_closure_date,acnts_db_freezed,acnts_curr_code,acnts_dormant_acnt from acnts where acnts_account_number=:acntNum",nativeQuery=true)
	public Object[] getAcntsDetails(@Param("acntNum") String acNum);

	@Query(value="SELECT EFT_CREDIT_GL_ACCESS,EFT_DEBIT_GL_ACCESS FROM EFTBANKCURRPARAM WHERE EFT_BANK_CODE =:bankCode and eft_currency_code=:currCode",nativeQuery=true)
	public Object[] getExternalAcnum(@Param("bankCode") String bankCode,@Param("currCode") String currCode);
	
}
