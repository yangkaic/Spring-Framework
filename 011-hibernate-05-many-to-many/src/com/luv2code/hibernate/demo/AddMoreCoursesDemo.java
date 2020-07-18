package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;


public class AddMoreCoursesDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int id = 3;
			
			Student stu = session.get(Student.class, id);
			
			Course course1 = new Course("adas");
			
			Course course2 = new Course("cvb");
			
			Course course3 = new Course("uiouoi");
			
			course1.addStudent(stu);
			
			course2.addStudent(stu);
			
			course3.addStudent(stu);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
			factory.close();
		}

	}

}
