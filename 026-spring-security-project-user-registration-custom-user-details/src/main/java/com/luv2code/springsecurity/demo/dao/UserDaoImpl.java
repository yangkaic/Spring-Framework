package com.luv2code.springsecurity.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String userName) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("from User where userName=:uName", User.class);
		query.setParameter("uName", userName);
		User user = null;
		
		try {
			user = query.getSingleResult();
			
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	@Override
	public void save(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(user);

	}

}
