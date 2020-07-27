package com.luv2code.springsecurity.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.UserService;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = Logger.getLogger(CustomAuthenticationSuccessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler");
		
		logger.info("===CustomAuthenticationSuccessHandler.onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, " + 
				"			Authentication authentication)");
		
		String userName = authentication.getName();
		
		
		logger.info("===userName = authentication.getName(): " + userName);
		
		User theUser = userService.findByUserName(userName);
		
		logger.info("===User theUser = userService.findByUserName(userName): " + theUser);
		
		logger.info("===NEXT PAGE: " + request.getContextPath() + "/employees");
		
		
		
		// now place in the sesison
		HttpSession session = request.getSession();
		session.setAttribute("user", theUser);
		
		//forward to home page
		response.sendRedirect(request.getContextPath() + "/employees");
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
	}

}
