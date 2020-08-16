package com.kaicheng.springbootin28Minutesmicroservices04currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kaicheng.springbootin28Minutesmicroservices04currencyconversionservice.CurrencyConversionBean;

//name is spring.applicaiton.name in application.properties file
//@FeignClient(name="currency-exchange-service", url="http://localhost:8000/037-springboot-in28Minutes-microservices-03-currency-exchange-service")// http:// can be omitted
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")// after we use @RibbonClient, the url can be dynamic not fixed port
public interface CurrencyExchangeServiceProxy {

	/**
	 * 
	 * @FeignClient(name="currency-exchange-service", url="http://localhost:8000/037-springboot-in28Minutes-microservices-03-currency-exchange-service")
	 * 
	 * supports following method
	 * 
	 * 
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(
			@PathVariable String from, @PathVariable String to);
	*/
	
	/**
	 * If we use @FeignClient(name="currency-exchange-service")
	 * 
	 * currency-exchange-service.ribbon.listOfServers 
	 * 
	 * doesn't support context-path, we can only specify http://localhost:xxxx or localhost:xxxx format.
	 * So we need to add context-path in @GetMapping()
	 * 
	 * Notes: This scenario without eureka. If use eureka, no need currency-exchange-service.ribbon.listOfServers
	 * 
	 * @param from
	 * @param to
	 * @return
	 
	@GetMapping("/037-springboot-in28Minutes-microservices-03-currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(
			@PathVariable String from, @PathVariable String to);
			
	*/
	
	@GetMapping("/currency-exchange-service/037-springboot-in28Minutes-microservices-03-currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(
			@PathVariable String from, @PathVariable String to);
	
	
}
