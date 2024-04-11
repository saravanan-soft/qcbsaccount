package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.AcntController;
import com.example.demo.dao.AcntsDao;
import com.example.demo.dao.BankCodeDao;
import com.example.demo.dao.EFTBANKCURRPARAMDao;
import com.example.demo.dao.EFTMAPBANKDao;
import com.example.demo.entity.Acnts;
import com.example.demo.entity.AcntsId;
import com.example.demo.entity.BankCode;
import com.example.demo.entity.EFTBANKCURRPARAM;
import com.example.demo.entity.EFTMAPBANK;
import com.example.demo.exception.AccountNotFoundException;
import com.example.demo.exception.BankCodeNotFound;
import com.example.demo.exception.EFTBankNotFound;
import com.example.demo.exception.ExtAccNotFound;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class AcntsService {
	
	private AcntsDao acntsDao;
    private EFTMAPBANKDao eftMapBankDao;
	private BankCodeDao bankCodeDao;
	private EFTBANKCURRPARAMDao eftBankCurParam;
	
	private static final Logger acntServLogger = LoggerFactory.getLogger(AcntsService.class);
	
	public AcntsService(AcntsDao acntsDao,EFTMAPBANKDao eftMapBankDao,BankCodeDao bankCodeDao,EFTBANKCURRPARAMDao eftBankCurParam) {
		this.acntsDao=acntsDao;
		this.eftMapBankDao=eftMapBankDao;
		this.bankCodeDao=bankCodeDao;
		this.eftBankCurParam=eftBankCurParam;
	}
	
	public Acnts saveAcnts(Acnts acnt) {	
		return this.acntsDao.save(acnt);	
	}
	
	public void delAcnts(AcntsId acntsId) {
		if(!acntsId.equals(null))
		this.acntsDao.deleteById(acntsId);
	}
	
	public boolean checkAcc(AcntsId acntsId){
		Acnts optAcntObj=this.acntsDao.findById(acntsId).orElseThrow(()->new AccountNotFoundException("Account doesnt exist"));
	    return true;
	}
	
	public String getEftMapBank(int eftCode) {
		acntServLogger.info("Step 6");
		String res=null;
		res=this.acntsDao.getEftMapBank(eftCode);
		if(res==null) {
			throw new EFTBankNotFound("EFT bank not available");
		}
		return res;
		
		
	}
	
	public Integer checkBankCode(String bankCode) {
		Integer i=0;
		i= this.acntsDao.checkBankCode(bankCode);
		if(i==0) {
			throw new BankCodeNotFound("Bank code not available");
		}
		return i;
	}
	
	public Object[]  getAcntsDetails(String acNum){
		Object[] obj=null;
		obj= this.acntsDao.getAcntsDetails(acNum);
		if(obj.length==0) {
			throw new AccountNotFoundException("Acc not found");
		}
	
		return obj;
	}
	
	public Object[]  getExternalAcnum(String bankCode,String currCode){
		Object[]  map=null;
		
		map=this.acntsDao.getExternalAcnum(bankCode, currCode);
		if(map.length==0) {
			throw new ExtAccNotFound("External mapping not found");
		}
		return map;
	}
	
	 
	 public EFTMAPBANK createEftMapBank(EFTMAPBANK eftMapBank) {
			EFTMAPBANK obj=null;
			obj= this.eftMapBankDao.save(eftMapBank);
			return obj;
		}
	
	public BankCode createBankCode(BankCode bankCode) {
		return this.bankCodeDao.save(bankCode);
	}
	
	//eftBankCurParam

	public EFTBANKCURRPARAM createEftBamkCur(EFTBANKCURRPARAM eftBankCur) {
		return this.eftBankCurParam.save(eftBankCur);
	}
}
