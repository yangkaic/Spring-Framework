package com.kaicheng.springboot.springbootdemocrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaicheng.springboot.springbootdemocrud.dao.EmployeeDAO;
import com.kaicheng.springboot.springbootdemocrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("employeeDAOJPAImpl")
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		List<Employee> list = employeeDAO.findAll();
		
		return list;
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		employeeDAO.deleteById(id);
		
	}

}
