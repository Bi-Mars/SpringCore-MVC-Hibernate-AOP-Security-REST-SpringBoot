package com.bimarsh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Course;
import com.bimarsh.hibernateEntity.Instructor;
import com.bimarsh.hibernateEntity.InstructorDetail;

public class CreateCourses {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			//start transaction
			session.beginTransaction();
			// get Instructor from database
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			//create some courses
			Course course1 = new Course("Air Guitar - The ultimate Guitar Guide");
			Course course2 = new Course("Option trading");
			
			//add courses to instructor  --> Associate course with instructor 
			instructor.add(course1);
			instructor.add(course2);
			
			// save the courses
			session.save(course1);
			session.save(course2);
			
			//commit transaction
			session.getTransaction().commit();

		}
		finally {
			//add clean up code
			session.close();
			factory.close();
		}

	}

}
