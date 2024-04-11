package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ACNTBALDao;
import com.example.demo.dao.AcntsDao;
import com.example.demo.entity.ACNTBAL;
import com.example.demo.entity.AcntBalId;
import com.example.demo.entity.Acnts;

@Service
public class AcntBalService {
	
private ACNTBALDao acntBalDao;
	
	public AcntBalService(ACNTBALDao acntBalDao) {
		this.acntBalDao=acntBalDao;
	}
	
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.MANDATORY)
	public boolean updateAcntBal(AcntBalId acntBalId,double acBal,double bcBal) {	
		Optional<ACNTBAL> optAcntBal=acntBalDao.findById(acntBalId);
		
		boolean result=false;
		if(optAcntBal.isPresent()) {
			optAcntBal.get().setAcntbalAcBal(acBal);
			optAcntBal.get().setAcntbalBcBal(bcBal);
			ACNTBAL res=this.acntBalDao.save(optAcntBal.get());
			result=true;
		}
		else {
			ACNTBAL acntBal=ACNTBAL.builder().acntBalId(acntBalId).acntbalAcBal(acBal).acntbalBcBal(bcBal).build();
			this.acntBalDao.save(acntBal);
			result=true;
		}
		
		
		return result;
	}
	
	public double getAcntBalAc(AcntBalId acntBalId) {
		Optional<ACNTBAL> optAcntAcBal=this.acntBalDao.findById(acntBalId);
		if(optAcntAcBal.isPresent()) {
			return optAcntAcBal.get().getAcntbalAcBal();
		}
		return 0.0;
	}
	
	public double getAcntBalBc(AcntBalId acntBalId) {
		Optional<ACNTBAL> optAcntBcBal=this.acntBalDao.findById(acntBalId);
		if(optAcntBcBal.isPresent()) {
			return optAcntBcBal.get().getAcntbalBcBal();
		}
		return 0.0;
	}

}
