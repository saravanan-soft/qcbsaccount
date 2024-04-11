package com.example.demo.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Tran;
import com.example.demo.entity.TranId;

public interface TranDao extends JpaRepository<Tran,TranId> {
	
	@Query(value="select COALESCE(MAX(tran_batch_number), 0) from tran where tran_brn_code=?1 and tran_date_of_tran=?2",nativeQuery=true)
	public Integer maxBatch(int brn,LocalDate date);
	
	@Query(value="select COALESCE(max(tran_batch_sl_number),0) from tran where tran_brn_code=?1 and tran_date_of_tran=?2 and tran_batch_number=?3",nativeQuery=true)
	public Integer maxBatchSl(int brn,LocalDate date,int batchNum);

}
