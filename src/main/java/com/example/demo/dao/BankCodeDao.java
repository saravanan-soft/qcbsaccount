package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BankCode;

public interface BankCodeDao extends JpaRepository<BankCode,Integer> {

}
