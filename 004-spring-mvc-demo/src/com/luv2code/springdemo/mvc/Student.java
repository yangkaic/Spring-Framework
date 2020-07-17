package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;

public class Student {
	
	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String secondaryCountry;
	
	private String thirdCountry;
	
	private String myProgrammingLanguage;
	
	private String mySecondaryProgrammingLanguage;
	
	private String[] operatingSystems;
	
	private LinkedHashMap<String, String> secondaryCountryOptions;
	
	private LinkedHashMap<String, String> secondaryProgrammingLanguageOptions;
	
	public Student() {
		
		this.secondaryCountryOptions = new LinkedHashMap<>();
		
		this.secondaryCountryOptions.put("BR", "Brazil");//key/code, value/label
		this.secondaryCountryOptions.put("USA", "USA");
		this.secondaryCountryOptions.put("FR", "France");
		this.secondaryCountryOptions.put("DE", "Germany");
		
		this.secondaryProgrammingLanguageOptions = new LinkedHashMap<>();
		this.secondaryProgrammingLanguageOptions.put("Java", "Java");
		this.secondaryProgrammingLanguageOptions.put("C++", "C++");
		this.secondaryProgrammingLanguageOptions.put("Python", "Python");
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public LinkedHashMap<String, String> getSecondaryCountryOptions() {
		return secondaryCountryOptions;
	}

	public void setSecondaryCountryOptions(LinkedHashMap<String, String> secondaryCountryOptions) {
		this.secondaryCountryOptions = secondaryCountryOptions;
	}

	public String getSecondaryCountry() {
		return secondaryCountry;
	}

	public void setSecondaryCountry(String secondaryCountry) {
		this.secondaryCountry = secondaryCountry;
	}

	public String getThirdCountry() {
		return thirdCountry;
	}

	public void setThirdCountry(String thirdCountry) {
		this.thirdCountry = thirdCountry;
	}

	public String getMyProgrammingLanguage() {
		return myProgrammingLanguage;
	}

	public void setMyProgrammingLanguage(String myProgrammingLanguage) {
		this.myProgrammingLanguage = myProgrammingLanguage;
	}

	public String getMySecondaryProgrammingLanguage() {
		return mySecondaryProgrammingLanguage;
	}

	public void setMySecondaryProgrammingLanguage(String mySecondaryProgrammingLanguage) {
		this.mySecondaryProgrammingLanguage = mySecondaryProgrammingLanguage;
	}

	public LinkedHashMap<String, String> getSecondaryProgrammingLanguageOptions() {
		return secondaryProgrammingLanguageOptions;
	}

	public void setSecondaryProgrammingLanguageOptions(LinkedHashMap<String, String> secondaryProgrammingLanguageOptions) {
		this.secondaryProgrammingLanguageOptions = secondaryProgrammingLanguageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	

}
