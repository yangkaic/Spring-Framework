package com.in28Minutes.springbootin28Minutesrestdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28Minutes.springbootin28Minutesrestdemo.dao.EmployeeDAO;
import com.in28Minutes.springbootin28Minutesrestdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
	}

	@Override
	public Employee save(Employee employee) {
		
		return employeeDAO.save(employee);
	}

	@Override
	public void deleteById(int id) {
		
		employeeDAO.deleteById(id);

	}

}
