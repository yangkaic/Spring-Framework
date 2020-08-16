package com.kaicheng.springbootin28Minutesmicroservices01limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


//we can use limits-service.* in application.properties file
//to customize our own properties
@Component
@ConfigurationProperties("limits-service")
public class LimitsPropertyConfiguration {
	
	private int minimum;
	
	private int maximum;
	

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	

}
