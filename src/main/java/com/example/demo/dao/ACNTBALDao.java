package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ACNTBAL;
import com.example.demo.entity.AcntBalId;


public interface ACNTBALDao extends JpaRepository<ACNTBAL,AcntBalId> {

}
