package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			List<Student> list = session.createQuery("from Student").getResultList();
			
			displayStudents(list);
			
			list = session.createQuery("from Student s where s.lastName='aasd'").getResultList();
			
			displayStudents(list);
			
			list = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			displayStudents(list);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> list) {
		for (Student stu : list) {
			System.out.println(stu);
		}
		
		System.out.println("**************************");
	}

}
