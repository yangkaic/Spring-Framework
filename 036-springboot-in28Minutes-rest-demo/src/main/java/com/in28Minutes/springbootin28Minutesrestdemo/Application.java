package com.in28Minutes.springbootin28Minutesrestdemo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@Bean
//	public LocaleResolver localeResolver() {
//		
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//		
//		localeResolver.setDefaultLocale(Locale.US);
//		
//		return localeResolver;
//	}
	
	@Bean
	public LocaleResolver localeResolverVersionTwo() {
		
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		
		localeResolver.setDefaultLocale(Locale.US);
		
		return localeResolver;
	}
	
	/* "spring.messages.basename = messages" in application.properties, we don't
	 * need following code
	@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		
		messageSource.setBasename("messages");
		
		return messageSource;
	}
	*/

}
