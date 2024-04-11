package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Currency;

public interface CurrencyDao extends JpaRepository<Currency,String> {

}
