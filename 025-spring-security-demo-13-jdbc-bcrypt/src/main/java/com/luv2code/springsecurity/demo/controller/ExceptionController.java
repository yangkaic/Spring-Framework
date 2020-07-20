package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {
	
	// add request mapping for /access-denied
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		
		return "access-denied";
	}

}
