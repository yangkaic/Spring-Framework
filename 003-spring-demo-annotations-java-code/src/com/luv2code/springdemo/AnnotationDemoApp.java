package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		
		Coach baseBallCoach = context.getBean("baseballCoach", Coach.class);
		
		SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
		
		
		System.out.println(baseBallCoach.getDailyWorkout());
		
		System.out.println(baseBallCoach.getDailyFortune());
		
		System.out.println(swimCoach.getDailyWorkout());
		
		System.out.println(swimCoach.getDailyFortune());
		
		System.out.println(swimCoach.getTeam());
		
		System.out.println(swimCoach.getEmail());
		
		context.close();

	}

}
