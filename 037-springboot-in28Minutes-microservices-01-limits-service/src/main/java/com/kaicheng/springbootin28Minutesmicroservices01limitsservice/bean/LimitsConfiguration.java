package com.kaicheng.springbootin28Minutesmicroservices01limitsservice.bean;

public class LimitsConfiguration {
	
	private int maximum;
	
	private int minimum;
	
	public LimitsConfiguration() {}
	
	public LimitsConfiguration(int maximum, int minimum) {
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
	

}
