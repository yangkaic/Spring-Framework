package com.in28Minutes.springbootin28Minutesrestdemo.restcontroller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28Minutes.springbootin28Minutesrestdemo.entity.Employee;
import com.in28Minutes.springbootin28Minutesrestdemo.exception.EmployeeNotFoundException;
import com.in28Minutes.springbootin28Minutesrestdemo.service.EmployeeService;

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
	public EntityModel<Employee> findById(@PathVariable int id) {

		Employee employee = employeeService.findById(id);

		if (employee == null) {
			throw new EmployeeNotFoundException("Employee id " + id + " not found");
		}

		// "all-users", SERVER_PATH + "/users"
		// retrieveAllUsers
		EntityModel<Employee> resource = EntityModel.of(employee);

		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).findAll());

		resource.add(linkTo.withRel("all-employees"));

		// HATEOAS

		return resource;
	}

	@PostMapping("/employees")
	public ResponseEntity<Object> save(@Valid @RequestBody Employee employee) {

		Employee savedEmployee = employeeService.save(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmployee.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/employees/{id}")
	public String deleteById(@PathVariable int id) {
		employeeService.deleteById(id);
		return "Employe id " + id + " deleted";
	}

}
