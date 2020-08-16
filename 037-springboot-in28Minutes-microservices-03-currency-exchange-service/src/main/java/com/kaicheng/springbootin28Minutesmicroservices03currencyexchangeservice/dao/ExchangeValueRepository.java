package com.kaicheng.springbootin28Minutesmicroservices03currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaicheng.springbootin28Minutesmicroservices03currencyexchangeservice.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
	
}
