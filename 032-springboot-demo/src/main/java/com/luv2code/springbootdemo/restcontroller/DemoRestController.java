package com.luv2code.springbootdemo.restcontroller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springbootdemo.entity.Employee;

@RestController
public class DemoRestController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;

	
	@GetMapping("/")
	public String sayHello() {
		
		
		return "Hello World! Time on server is: " + LocalDateTime.now() + 
		" Coach: " + coachName + " Team: " + teamName;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return Arrays.asList(new Employee("A", 1), new Employee("B", 2));
	}
}
