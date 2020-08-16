package com.in28Minutes.springbootin28Minutesrestdemo.restcontroller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldRestConttoller {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String sayHello() {
		
		return "Hello";
	}
	
	@GetMapping("/hello-world")
	public String sayHelloWorld() {
		
		return "Hello World";
	}
	
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	@GetMapping("/hello-world-internationalized-version-two")
	public String helloWorldInternationalizedVersionTwo() {
		
		return messageSource.getMessage("good.morning.message", null,
				LocaleContextHolder.getLocale());
	}
	
	

}
