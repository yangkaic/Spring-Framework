package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		
		return "helloworld-form";
	}
	
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
		
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(HttpServletRequest request, Model model) {
		
		String result = request.getParameter("studentName");
		
		result = result.toUpperCase();
		
		result = "Yo! " + result;
		
		model.addAttribute("message", result);
		
		return "helloworld";
		
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String result, Model model) {
		
		
		result = result.toUpperCase();
		
		result = "Yo V3! " + result;
		
		model.addAttribute("message", result);
		
		return "helloworld";
		
	}

}
