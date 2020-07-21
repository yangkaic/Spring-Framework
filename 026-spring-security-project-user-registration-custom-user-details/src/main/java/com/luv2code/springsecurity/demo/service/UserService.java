package com.luv2code.springsecurity.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.user.CrmUser;

public interface UserService extends UserDetailsService {
	
	public User findByUserName(String userName);
	
	public void save(CrmUser crmUser);

}
