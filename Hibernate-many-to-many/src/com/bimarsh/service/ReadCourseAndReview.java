package com.bimarsh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Course;
import com.bimarsh.hibernateEntity.Instructor;
import com.bimarsh.hibernateEntity.InstructorDetail;
import com.bimarsh.hibernateEntity.Review;

public class ReadCourseAndReview {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			//start transaction
			session.beginTransaction();
			
			//get the course
			int id = 3;
			Course tempCourse = session.get(Course.class,id);
			
			//print the course
			System.out.println("Course: " + tempCourse.toString());
			
			//print course review
			// Lazy Fetch. So we get Course first, and then when code below executes, Hibernate makes another trip to database
			System.out.println("Course: " + tempCourse.getReviews());
			
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
