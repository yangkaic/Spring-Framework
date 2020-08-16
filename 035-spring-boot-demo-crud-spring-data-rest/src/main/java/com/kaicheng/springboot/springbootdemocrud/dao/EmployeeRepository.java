package com.kaicheng.springboot.springbootdemocrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kaicheng.springboot.springbootdemocrud.entity.Employee;

@RepositoryRestResource(path = "members")// default is /employees
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// noe need to write any code
}
