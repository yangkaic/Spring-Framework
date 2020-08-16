package com.kaicheng.springboot.springbootdemocrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaicheng.springboot.springbootdemocrud.dao.EmployeeRepository;
import com.kaicheng.springboot.springbootdemocrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override // JpaRepository provides @Transactional functionality
	public List<Employee> findAll() {
		
		List<Employee> list = employeeRepository.findAll();
		
		return list;
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		if (result.isPresent()) {
			return result.get();
		}
		
		return null;
	}

	@Override
	public void save(Employee employee) {
		
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		
		employeeRepository.deleteById(id);
		
	}

}
