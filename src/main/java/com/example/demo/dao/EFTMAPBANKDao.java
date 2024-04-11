package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.EFTMAPBANK;

public interface EFTMAPBANKDao extends JpaRepository<EFTMAPBANK,Integer>{

}
