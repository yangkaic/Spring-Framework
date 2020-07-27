package com.luv2code.springsecurity.demo.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	private static final Logger logger = Logger.getLogger(RoleDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Role findRoleByName(String theRoleName) {
		
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		
		logger.info("BEGIN ******************************************");
		
		logger.info("===RoleDaoImpl.findRoleByName(String theRoleName)");
		
		
		
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Role> query = session.createQuery("from Role where name=:roleName", Role.class);
		
		query.setParameter("roleName", theRoleName);
		Role role = null;
		
		try {
			role = query.getSingleResult();
		} catch (Exception e) {
			role = null;
		}
		
		logger.info("===theRoleName: " + theRoleName);
		logger.info("===role: " + role);
		logger.info("END ******************************************");
		logger.info("\n\n\n");
		logger.info("\n\n\n");
		return role;
	}

}
