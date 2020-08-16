package com.in28Minutes.springbootin28Minutesrestdemo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.in28Minutes.springbootin28Minutesrestdemo.entity.Employee;
import com.in28Minutes.springbootin28Minutesrestdemo.exception.EmployeeConflictException;
import com.in28Minutes.springbootin28Minutesrestdemo.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static List<Employee> employees = new ArrayList<>();
	
	private static int usersCount = 5;
	
	static {
		
		employees.add(new Employee(1, "A", new Date()));
		employees.add(new Employee(2, "B", new Date()));
		employees.add(new Employee(3, "C", new Date()));
		employees.add(new Employee(4, "D", new Date()));
		employees.add(new Employee(5, "E", new Date()));
	}

	@Override
	public List<Employee> findAll() {
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		Employee result = null;
		
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				result = employee;
			}
		}
		
		return result;
	}

	@Override
	public Employee save(Employee employee) {
		
		if (employee.getId() == null) {
			++usersCount;
			for (int i = 0; i < employees.size(); i++) {
				if (usersCount == employees.get(i).getId()) {
					++usersCount;
				}
			}
			employee.setId(usersCount);
		} else {
			for (Employee temp : employees) {
				if (temp.getId() == employee.getId()) {
					throw new EmployeeConflictException("Employee id " + employee.getId() + " alreay exists");
				}
			}
		}
		employees.add(employee);
		
		return employee;
	}

	@Override
	public void deleteById(int id) {
		
		Employee employee = findById(id);
		
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee id " + id + " not found");
		}
		
		employees.remove(employee);
		
	}
	
	
	public void deleteByIdVersionTwo(int id) {
		
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			if (employee.getId() == id) {
				iterator.remove();
				return;
			}
		}
		
		throw new EmployeeNotFoundException("Employee id " + id + " not found");
		
	}

}
