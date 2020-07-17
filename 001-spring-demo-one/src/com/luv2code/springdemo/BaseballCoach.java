package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService myFortuneService;
	
	public String team;
	
	public String email;
	
	public BaseballCoach() {}
	
	public BaseballCoach(FortuneService myFortuneService) {
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
		return "Spend 30 minutes on batting practice";
	}
	
	@Override
	public String getDailyFortune() {
		return myFortuneService.getFortune();
	}

}
