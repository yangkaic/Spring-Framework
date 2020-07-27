package com.luv2code.springsecurity.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.RoleDao;
import com.luv2code.springsecurity.demo.dao.UserDao;
import com.luv2code.springsecurity.demo.entity.Role;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.user.CrmUser;

@Service
public class UserServiceImpl implements UserService {
	
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	//need to inject user dao
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===UserServiceImpl.loadUserByUsername(String username)");
		
		logger.info("===username: " + username);
		
		
		
		
		User user = userDao.findByUserName(username);
		logger.info("===User user = userDao.findByUserName(username): " + user);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		logger.info("===user.getUserName(): " + user.getUserName());
		logger.info("===user.getPassword(): " + user.getPassword());
		logger.info("===user.getRoles(): " + user.getRoles());
		
		UserDetails userDetail = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), 
				mapRolesToAuthorities(user.getRoles()));
		
		logger.info("===UserDetails: " + userDetail);
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		return userDetail;
	}

	@Override
	@Transactional
	public User findByUserName(String userName) {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===UserServiceImpl.findByUserName(String userName)");
		
		logger.info("===userName: " + userName);
		
		User user = userDao.findByUserName(userName);
		
		logger.info("===userDao.findByUserName(userName): " + user);
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		return user;
	}

	@Override
	@Transactional
	public void save(CrmUser crmUser) {
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===UserServiceImpl.save(CrmUser crmUser)");
		
		logger.info("===CrmUser: " + crmUser);
		
		
		
		User user = new User();
		
		//assign user details to the user object
		
		user.setUserName(crmUser.getUserName());
		user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
		user.setFirstName(crmUser.getFirstName());
		user.setLastName(crmUser.getLastName());
		user.setEmail(crmUser.getEmail());
		
		// give user default role of "employee"
		user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_EMPLOYEE")));
		
		userDao.save(user);
		
		logger.info("===userDao.save(user): " + user);
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
	}
	
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===UserServiceImpl.mapRolesToAuthorities(Collection<Role> roles)");
		
		logger.info(roles);
		
		logger.info("===roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())");
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
