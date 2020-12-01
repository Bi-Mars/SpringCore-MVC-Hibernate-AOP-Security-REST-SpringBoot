package com.bimarsh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Course;
import com.bimarsh.hibernateEntity.Instructor;
import com.bimarsh.hibernateEntity.InstructorDetail;

public class EagerLazy {

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
			// all related entities are loaded
			Instructor instructor = session.get(Instructor.class, id);
						
		     System.out.println(" \"this is my code \" +Instructor: " + instructor);
			//get courses for the instructor
			System.out.println("\"this is my code \" +Courses: " + instructor.getCourses());
			
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
