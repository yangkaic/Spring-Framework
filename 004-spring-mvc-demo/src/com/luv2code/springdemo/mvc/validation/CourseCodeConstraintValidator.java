package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}
	
	@Override
	public boolean isValid(String input, ConstraintValidatorContext arg1) {
		
		boolean result = false;
		
		if (input != null) {
			result = input.startsWith(coursePrefix);
		} 
		return result;
	}
	
}
