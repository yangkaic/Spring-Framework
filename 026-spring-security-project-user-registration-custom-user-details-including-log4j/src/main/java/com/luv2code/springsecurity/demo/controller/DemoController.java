package com.luv2code.springsecurity.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	
	private static final Logger logger = Logger.getLogger(DemoController.class);
	
	@GetMapping("/")
	public String showLandingPage() {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===DemoController.showLandingPage(), @GetMapping(/). Next Page: landing.jsp");
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		return "landing";
	}

	@GetMapping("/employees")
	public String showHome() {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===DemoController.showHome(), @GetMapping(/employees). Next Page: home.jsp");
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		return "home";
	}
	
	// add request mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===DemoController.showLeaders(), @GetMapping(/leaders). Next Page: leaders.jsp");
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		return "leaders";
	}
	
	
	// add request mapping for /systems
		@GetMapping("/systems")
		public String showSystems() {
			
			logger.info("\n\n\n");
			logger.info("\n\n\n");
			
			logger.info("BEGIN ******************************************");
			
			logger.info("===DemoController.showSystems(), @GetMapping(/systems). Next Page: systems.jsp");
			
			logger.info("END ******************************************");
			
			logger.info("\n\n\n");
			logger.info("\n\n\n");
			
			return "systems";
		}

}
