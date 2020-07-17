package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	FortuneService myFortuneService;
	
	@Value("${foo.team}")
	public String team;
	
	@Value("${foo.email}")
	public String email;
	
	public SwimCoach() {
		
	}
	
	public SwimCoach(FortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getDailyWorkout() {
		return "Today I am going to swim";
	}

	@Override
	public String getDailyFortune() {
		return myFortuneService.getFortune();
	}

}
