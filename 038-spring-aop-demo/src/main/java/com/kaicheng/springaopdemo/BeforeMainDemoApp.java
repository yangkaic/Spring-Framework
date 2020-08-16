package com.kaicheng.springaopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kaicheng.springaopdemo.before.dao.AccountDAO;
import com.kaicheng.springaopdemo.before.dao.MembershipDAO;

public class BeforeMainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		accountDAO.addAccount();
		
		membershipDAO.addAccount();
		
		context.close();

	}

}
