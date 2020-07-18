package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	FortuneService myFortuneService;
	
	@Value("${foo.team}")
	public String team;
	
	@Value("${foo.email}")
	public String email;
	
	@PostConstruct
	public void doStartupStaff() {
		System.out.println("Do some startup staff");
	}
	
	@PreDestroy
	public void doCleanupStaff() {
		System.out.println("Do some cleanup staff");
	}
	
	

	@Override
	public String getDailyWorkout() {
		
		return "Practice your backend volley";
	}

	@Override
	public String getDailyFortune() {
		
		return myFortuneService.getFortune();
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
	
	
	
	

}
