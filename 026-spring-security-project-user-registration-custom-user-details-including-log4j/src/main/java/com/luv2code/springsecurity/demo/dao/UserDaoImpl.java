package com.luv2code.springsecurity.demo.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String userName) {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===UserDaoImpl.findByUserName(String userName)");
		logger.info("===usrName: " + userName);
		
		
		
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("from User where userName=:uName", User.class);
		query.setParameter("uName", userName);
		User user = null;
		
		try {
			user = query.getSingleResult();
			
		} catch (Exception e) {
			user = null;
		}
		
		logger.info("===user: " + user);
		logger.info("END ******************************************");
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		return user;
	}

	@Override
	public void save(User user) {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===UserDaoImpl.save(User user)");
		
		logger.info("===user: " + user);
		
		logger.info("===session.saveOrUpdate(user);");
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(user);
		
		logger.info("END ******************************************");
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		

	}

}
