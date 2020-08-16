package com.in28Minutes.springbootin28Minutesrestdemo;

import java.util.Arrays;


import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


/**
 * http://localhost:8080/036-springboot-in28Minutes-rest-demo/v2/api-docs
 * 
 * http://localhost:8080/036-springboot-in28Minutes-rest-demo/swagger-ui/index.html
*/
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact(
			"Kaicheng Yang", "www.kaicheng.com", "kaicheng@gmail.com");
	
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			"Awesome API Title",
			"Awesome API Description",
			"1.0",
			"urn:tos",
			DEFAULT_CONTACT,
			"Apache 2.0",
			"http://www.apache.org/lcenses/LICENSE-2.0",
			Arrays.asList());
	
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
			new HashSet<>(Arrays.asList("application/json", 
					"application/xml"));
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
	

}
