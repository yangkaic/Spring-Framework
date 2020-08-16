package com.kaicheng.springboot.springbootdemocrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaicheng.springboot.springbootdemocrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// noe need to write any code
}
