package com.kaicheng.springboot.springbootdemocrud.dao;

import java.util.List;

import com.kaicheng.springboot.springbootdemocrud.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);

}
