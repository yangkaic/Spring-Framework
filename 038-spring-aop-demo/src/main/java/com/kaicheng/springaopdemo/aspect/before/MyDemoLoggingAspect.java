package com.kaicheng.springaopdemo.aspect.before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	/*
	 * Separate the following two advice into two Aspect classes and 
	 * 
	 * use @Order(x) to order.
	 * 
	 * Lower number has higher priorities.
	 * 
	 * 
	 * 
	 * */
	
	// @Before advice
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====> Executing @Before advice on addAccount()");
	}
	
	@Before("execution(public void com.kaicheng.springaopdemo.before.dao.MembershipDAO.addAccount())")
	public void beforeAddAccountAdviceOnlyOnMembershipDAO() {
		System.out.println("\n=====> Executing @Before advice only on com.kaicheng.springaopdemo.before.dao.MembershipDAO.addAccount()");
	}

}
