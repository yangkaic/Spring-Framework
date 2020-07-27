package com.luv2code.springsecurity.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===LoginController.showMyLoginPage(), @GetMapping(/showMyLoginPage). Next Page: fancy-login.jsp");
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		//return "plain-login";
		return "fancy-login";
	}
	
}
