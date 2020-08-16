package com.kaicheng.springboot.springbootdemocrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kaicheng.springboot.springbootdemocrud.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		
		//javax.persistence.Query
		
		Query query = entityManager.createQuery("from Employee");
		
		List<Employee> list = query.getResultList();
		
		return list;
	}

	@Override
	public Employee findById(int id) {
		
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// save or update the employee
		Employee dbEmployee = entityManager.merge(employee);
		
		//update with id from db.. so we can get genereated id for save/insert
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {

		Query query = entityManager.createQuery(
				"delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
		
	}

}
