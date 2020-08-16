package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;
import com.luv2code.springdemo.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> list;
	
	@PostConstruct
	public void loadData() {
		
		list = new ArrayList<>();
		list.add(new Student("A", "A"));
		list.add(new Student("B", "B"));
		list.add(new Student("C", "C"));
		list.add(new Student("D", "D"));
	}

	@GetMapping("/students")
	public List<Student> listStudents() {
		
		return list;
		
	}
	
	@GetMapping("/students/{studentId}")
	public Student listStudent(@PathVariable int studentId) {
		
		if (studentId >= list.size() || studentId < 0) {
			throw new StudentNotFoundException("Not found studnet: " + studentId);
		}
		
		return list.get(studentId);
	}
	
	
}
