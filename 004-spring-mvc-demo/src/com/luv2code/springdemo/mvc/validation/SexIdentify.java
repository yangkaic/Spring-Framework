package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = SexIdentifyConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SexIdentify {

	
	//define default course code
		public String[] value() default {"NULL"};
		
		//define default error message
		public String message() default "If you don't type, the default sex is NULL";
		
		//define default groups
		public Class<?>[] groups() default {};
		
		//define default payloads
		public Class<? extends Payload>[] payload() default {};
}
