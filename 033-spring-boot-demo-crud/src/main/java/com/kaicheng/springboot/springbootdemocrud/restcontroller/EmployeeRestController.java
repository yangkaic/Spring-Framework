package com.kaicheng.springboot.springbootdemocrud.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaicheng.springboot.springbootdemocrud.entity.Employee;
import com.kaicheng.springboot.springbootdemocrud.exception.EmployeeNotFoundException;
import com.kaicheng.springboot.springbootdemocrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
		
		Employee employee = employeeService.findById(id);
		
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee id " + id + " not found");
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		
		employeeService.save(employee);
		
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteById(@PathVariable int id) {
		
		Employee employee = employeeService.findById(id);
		
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee id " + id + " not found");
		}
		
		employeeService.deleteById(id);
		
		return "Employee id: " + id + " deleted";
	}

}
