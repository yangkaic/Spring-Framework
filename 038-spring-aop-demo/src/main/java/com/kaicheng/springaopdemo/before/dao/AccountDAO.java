package com.kaicheng.springaopdemo.before.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": Doing work on AccountDAO.addAccount()\n");
	}

}
