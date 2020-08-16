package com.in28Minutes.springbootin28Minutesrestdemo.service;

import java.util.List;

import com.in28Minutes.springbootin28Minutesrestdemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public Employee save(Employee employee);
	
	public void deleteById(int id);

}
