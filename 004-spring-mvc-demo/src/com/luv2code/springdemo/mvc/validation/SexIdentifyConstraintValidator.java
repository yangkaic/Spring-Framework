package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexIdentifyConstraintValidator implements ConstraintValidator<SexIdentify, String> {

	private String[] sexSet;
	
	@Override
	public void initialize(SexIdentify sexIdentify) {
		sexSet = sexIdentify.value();
	}
	
	@Override
	public boolean isValid(String input, ConstraintValidatorContext arg1) {
		
		boolean result = false;
		
		if (input != null) {
			
			for (String str : sexSet) {
				
				if (input.toUpperCase().equals(str)) {
					result = true;
					break;
				}
			}
		}
		
		return result;
	}

}
