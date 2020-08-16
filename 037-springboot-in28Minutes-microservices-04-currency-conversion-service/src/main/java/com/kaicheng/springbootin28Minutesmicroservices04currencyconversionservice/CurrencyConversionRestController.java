package com.kaicheng.springbootin28Minutesmicroservices04currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kaicheng.springbootin28Minutesmicroservices04currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionRestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> responseEntity 
			= restTemplate.getForEntity(
				"http://localhost:8000/037-springboot-in28Minutes-microservices-03-currency-exchange-service/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversionBean.class, 
				uriVariables);
		
		CurrencyConversionBean response = responseEntity.getBody();
		
		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(
				response.getId(),
				from,
				to,
				response.getConversionMultiple(),
				quantity,
				quantity.multiply(response.getConversionMultiple()),
				response.getPort()
				);
		
		return currencyConversionBean;
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyUsingFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConversionBean response 
			= currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
				
		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(
				response.getId(),
				from,
				to,
				response.getConversionMultiple(),
				quantity,
				quantity.multiply(response.getConversionMultiple()),
				response.getPort()
				);
		
		logger.info("{}", response);
		
		return currencyConversionBean;
	}

}
