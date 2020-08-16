package com.in28Minutes.springbootin28Minutesrestdemo.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.in28Minutes.springbootin28Minutesrestdemo.entity.SomeBean;

@RestController
@RequestMapping("/api")
public class FilteringRestController {
	
	@GetMapping("/static-filtering")// need to enable annotations on "SomeBean", right now disabled
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1", "value2", "value3");
	}
	
	@GetMapping("/static-filtering-list")//need to enable annotations on "SomeBean", right now disabled
	public List<SomeBean> retrieveListOfSomeBean() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), 
				new SomeBean("value12", "value22", "value32"),
				new SomeBean("value13", "value23", "value33"));
	}
	
	
	//filter field1, field2
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retrieveSomeBeanDynamic() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		
		FilterProvider filters = 
				new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter);
				
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	//filter field2, field3
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retrieveListOfSomeBeanDynamic() {
		List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1", "value2", "value3"), 
				new SomeBean("value12", "value22", "value32"),
				new SomeBean("value13", "value23", "value33"));
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters =
				new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBeanList);
		mapping.setFilters(filters);
		
		return mapping;
	}

}
