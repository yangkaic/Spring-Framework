package com.luv2code.springsecurity.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {
	
	private static final Logger logger = Logger.getLogger(ExceptionController.class);
	
	// add request mapping for /access-denied
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===ExceptionController.showAccessDeniedPage(), @GetMapping(/access-denied). Next Page: access-denied.jsp");
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		return "access-denied";
	}

}
