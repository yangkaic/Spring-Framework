package com.luv2code.springsecurity.demo.controller;

import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.UserService;
import com.luv2code.springsecurity.demo.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	private static final Logger logger = Logger.getLogger(RegistrationController.class);
	
	@Autowired
	private UserService userService;
	
	
	private LinkedHashMap<String, String> roles;
	
	@PostConstruct
	protected void loadRoles() {
		roles = new LinkedHashMap<>();
		
		//key = role, value = display to user
		roles.put("ROLE_EMPLOYEE", "Employee");
		roles.put("ROLE_MANAGER", "Manager");
		roles.put("ROLE_ADMIN", "Admin");
		
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showRegistrationForm")
	public String showMyRegistrationForm(Model model) {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===RegistrationController.showMyRegistrationForm(Model model), @GetMapping(/showRegistrationForm). Next Page: registration-form.jsp");
		
		
		model.addAttribute("crmUser", new CrmUser());
		
		model.addAttribute("roles", roles);
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
			BindingResult theBindingResult, Model model) {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===RegistrationController.processRegistrationForm(@Valid @ModelAttribute(\"crmUser\") CrmUser theCrmUser,\n" + 
				"			BindingResult theBindingResult, Model model), @GetMapping(/processRegistrationForm). Next Page: registration-confirmation.jsp");
		
		
		
		String userName = theCrmUser.getUserName();
		
		logger.info("===Processing registration form for: " + userName);
		
		if (theBindingResult.hasErrors()) {
			logger.info("************===Inside theBindingResult.hasErrors()===BEGIN************");
			logger.info("Current USER: " + theCrmUser);
			model.addAttribute("roles", roles);
			logger.info("************===Inside theBindingResult.hasErrors()===END************");
			return "registration-form";
		}
		
		User existing = userService.findByUserName(userName);
		
		logger.info("===User existing = userService.findByUserName(userName)");
		logger.info("===existing: " + existing);
		
		if (existing != null) {
			model.addAttribute("crmUser", new CrmUser());
			model.addAttribute("roles", roles);
			model.addAttribute("registrationError", "User name already exists.");
			logger.warn("User name already exists.");
			return "registration-form";
		}
		
		userService.save(theCrmUser);
		
		logger.info("===Success...userService.save(theCrmUser): " + theCrmUser);
		
		logger.info("===Successfully created user: " + userName);
		
		logger.info("END ******************************************");
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		return "registration-confirmation";
		
	}

}
