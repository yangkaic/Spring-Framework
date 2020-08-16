package com.kaicheng.springaopdemo.before.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		
		System.out.println(getClass() + ": Doing work on MembershipDAO.addAccount()\n");
	}

}
