package com.kaicheng.springbootin28Minutesmicroservices01limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaicheng.springbootin28Minutesmicroservices01limitsservice.bean.LimitsConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationRestController {
	
	@Autowired
	private LimitsPropertyConfiguration limitsPropertyConfiguration;
	
	@GetMapping("/limits-configuration")
	public LimitsConfiguration retrieveLimitsConfiguration() {
		
		return new LimitsConfiguration(limitsPropertyConfiguration.getMaximum(), 
				limitsPropertyConfiguration.getMinimum());
	}
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
	public LimitsConfiguration retrieveConfiguration() {
		
		throw new RuntimeException("Not available");
	}
	

	public LimitsConfiguration fallbackRetrieveConfiguration() {
		
		return new LimitsConfiguration(limitsPropertyConfiguration.getMaximum(), 
				limitsPropertyConfiguration.getMinimum());
	}
}
