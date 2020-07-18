package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
	
	@Autowired
	@Qualifier("happyFortuneService")
	FortuneService myFortuneService;
	
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
		
		return "BaseballCoach practice backend everyday!";
	}

	@Override
	public String getDailyFortune() {
		return myFortuneService.getFortune();
	}

}
