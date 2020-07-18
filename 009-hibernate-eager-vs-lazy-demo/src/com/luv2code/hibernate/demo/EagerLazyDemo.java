package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class EagerLazyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int id = 1;
			
			Instructor instructor = session.get(Instructor.class, id);
			
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			/*
			//since course are lazy loaded... this should fail
			System.out.println(instructor.getCourses());*/
			
			
			/*
			 * If you reopen another session and getCourses(), it still fails.
			 * You must call getCourses() during previous session!!!!!
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println(instructor.getCourses());
			session.getTransaction().commit();
			*/
			
		} finally {
			
			session.close();
			factory.close();
		}

	}

}
