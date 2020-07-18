package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		TennisCoach theCoach = context.getBean("thatSillyCoach", TennisCoach.class);
		
		Coach baseBallCoach = context.getBean("baseballCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getTeam());
		
		System.out.println(theCoach.getEmail());
		
		System.out.println(baseBallCoach.getDailyWorkout());
		
		context.close();

	}

}
