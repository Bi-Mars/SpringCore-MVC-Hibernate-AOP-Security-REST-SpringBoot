package com.bimarsh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Course;
import com.bimarsh.hibernateEntity.Instructor;
import com.bimarsh.hibernateEntity.InstructorDetail;
import com.bimarsh.hibernateEntity.Review;
import com.bimarsh.hibernateEntity.Student;

public class ReadCoursesForBimarsh {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			//start transaction
			session.beginTransaction();
			
			// get student
			int student_id = 1;
			Student theStudent = session.get(Student.class, student_id);
			System.out.println("\n Student: " + theStudent.getCourses());
					
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
