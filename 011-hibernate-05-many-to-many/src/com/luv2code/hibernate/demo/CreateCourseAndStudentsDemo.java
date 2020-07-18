package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;


public class CreateCourseAndStudentsDemo {

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
			
			Course course = new Course("2222");
			
			session.save(course);
			
			//add students to the course
			Student stu1 = new Student("abc", "abc", "111@gmail.com");
			Student stu2 = new Student("aa", "aa", "111@gmail.com");
			
			course.addStudent(stu1);
			course.addStudent(stu2);
			
			session.save(stu1);
			session.save(stu2);
			
			session.getTransaction().commit();
			
		} finally {
			
			session.close();
			factory.close();
		}

	}

}
