package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			session.beginTransaction();
			
			Student stu = session.get(Student.class, studentId);
			
			stu.setEmail("111@gmail.com");
			
			session.getTransaction().commit();
			
			//New session
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("update Student set email='12345@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}
