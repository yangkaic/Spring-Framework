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

import com.luv2code.springdemo.entity.Book;
import com.luv2code.springdemo.entity.Student;
import com.luv2code.springdemo.exception.BookNotFoundException;
import com.luv2code.springdemo.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class BookRestController {
	
	private List<Book> list;
	
	@PostConstruct
	public void loadData() {
		
		list = new ArrayList<>();
		list.add(new Book("A", 1.2));
		list.add(new Book("B", 3.3));
		list.add(new Book("C", 1.2));
		list.add(new Book("D", 7.7));
	}

	@GetMapping("/books")
	public List<Book> listBooks() {
		
		return list;
		
	}
	
	@GetMapping("/books/{bookId}")
	public Book listBook(@PathVariable int bookId) {
		
		if (bookId >= list.size() || bookId < 0) {
			throw new BookNotFoundException("Not found book: " + bookId);
		}
		
		return list.get(bookId);
	}
	
	
}
