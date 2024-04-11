package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TranDao;
import com.example.demo.entity.ACNTBAL;
import com.example.demo.entity.AcntBalId;
import com.example.demo.entity.Tran;
import com.example.demo.entity.TranId;
import com.example.demo.exception.BatchNumNotFoundException;

import dto.PostDto;


@Service
public class TranService {
	
	private TranDao tranDao;
	private AcntBalService acntBalService;
	
	public TranService(TranDao tranDao,AcntBalService acntBalService) {
		this.tranDao=tranDao;
		this.acntBalService=acntBalService;
	}
	
	@Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public int postTran(List<PostDto> postDto) {
		
		int brnCode=postDto.get(0).getTran_brn_code();	
		LocalDate localDate=postDto.get(0).getTran_date_of_tran();
		Integer batchNum=this.tranDao.maxBatch(brnCode, localDate)+1;
		
		if(batchNum==0) {
			//throw new batchNumException();
			throw new BatchNumNotFoundException("Batch number not generated");
		}
		
		postDto.stream().filter(e -> e.getTranDbCrFlg()=='D').forEach(p->{
		    this.debit(p,batchNum);	
		});
		
		postDto.stream().filter(e -> e.getTranDbCrFlg()=='C').forEach(p->{
			 this.credit(p,batchNum);	
		});
		
	
		
		return batchNum;
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public int debit(PostDto postDto,int batchNum) {
		
	
		Integer batchNumSl=this.tranDao.maxBatchSl(postDto.getTran_brn_code(), postDto.getTran_date_of_tran(),batchNum)+1;    	
	    if(batchNumSl != 0) {
	    	
	    	AcntBalId acntBalId=new AcntBalId(postDto.getTranAcnum(),postDto.getTranCurrCode());
	    	
	    	if(acntBalId !=null) {
	    		double existAcBal=acntBalService.getAcntBalAc(acntBalId);
	    		double newUptdAcBal=existAcBal+postDto.getTranAmount();
	    		double existBcBal=acntBalService.getAcntBalBc(acntBalId);
	    		double newUptdBcBal=existBcBal+postDto.getTranAmount();	
	    		boolean result=acntBalService.updateAcntBal(acntBalId,newUptdAcBal,newUptdBcBal);
	    		if(result) {
	    			
	    			TranId tranid=new TranId(postDto.getTran_brn_code(),postDto.getTran_date_of_tran(),batchNum,batchNumSl);
	    			Tran tran=Tran.builder().tranId(tranid).tranAcnum(postDto.getTranAcnum()).tranAcingBrnCode(postDto.getTran_brn_code()).tranAmount(postDto.getTranAmount()).tranBaseCurrCode("SCR").tranBaseCurrConvRate(1.0).tranBaseCurrEqAmt(postDto.getTranAmount()).tranCode(postDto.getTranCode()).tranCurrCode(postDto.getTranCurrCode()).tranDbCrFlg('D').tranEntdBY("EFT").tranEntdOn(LocalDateTime.now()).tranNarrDtl1("EFT external payment").tranOption('A').tranValueDate(postDto.getTranValueDate()).build();
	    			if(this.tranDao.findById(tranid).isPresent()){
	    				//throw duplicate tran
	    				
	    			}
	    			else {
	    				this.tranDao.save(tran);
	    			}
	    		}
	    	}
	    	
	    			
	    }
	    else {
	    	//throw new 
	    	throw new BatchNumNotFoundException("Batch number not generated");
	    }
		return batchNumSl;
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public int credit(PostDto postDto,int batchNum) {
		Integer batchNumSl=this.tranDao.maxBatchSl(postDto.getTran_brn_code(), postDto.getTran_date_of_tran(),batchNum)+1;    	
	    if(batchNumSl != 0) {
	    	//throw new
	    	AcntBalId acntBalId=new AcntBalId(postDto.getTranAcnum(),postDto.getTranCurrCode());
	    	if(acntBalId !=null) {
	    		double existAcBal=acntBalService.getAcntBalAc(acntBalId);
	    		double newUptdAcBal=existAcBal-postDto.getTranAmount();
	    		double existBcBal=acntBalService.getAcntBalBc(acntBalId);
	    		double newUptdBcBal=existBcBal+postDto.getTranAmount();	
	    		boolean result=acntBalService.updateAcntBal(acntBalId,newUptdAcBal,newUptdBcBal);
	    		if(result) {
	    			TranId tranid=new TranId(postDto.getTran_brn_code(),postDto.getTran_date_of_tran(),batchNum,batchNumSl);
	    			if(this.tranDao.findById(tranid).isPresent()){
	    				//throw duplicate tran
	    				
	    			}
	    			Tran tran=Tran.builder().tranId(tranid).tranAcnum(postDto.getTranAcnum()).tranAcingBrnCode(postDto.getTran_brn_code()).tranAmount(postDto.getTranAmount()).tranBaseCurrCode("SCR").tranBaseCurrConvRate(1.0).tranBaseCurrEqAmt(postDto.getTranAmount()).tranCode(postDto.getTranCode()).tranCurrCode(postDto.getTranCurrCode()).tranDbCrFlg('C').tranEntdBY("EFT").tranEntdOn(LocalDateTime.now()).tranNarrDtl1("EFT external payment").tranOption('A').tranValueDate(postDto.getTranValueDate()).build();
	    		    this.tranDao.save(tran);
	    		}
	    	}		
	    }
	    else {
	    	//throw new 
	    	throw new BatchNumNotFoundException("Batch number not generated");
	    }
		return batchNumSl;
	}
}
