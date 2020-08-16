package com.in28Minutes.springbootin28Minutesrestdemo.entity;

public class PersonV1 {
	
	private String firstName;
	
	private String lastName;
	
	public PersonV1() {}

	public PersonV1(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
	

}
