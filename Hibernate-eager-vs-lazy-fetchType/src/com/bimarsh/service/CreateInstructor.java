package com.bimarsh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Course;
import com.bimarsh.hibernateEntity.Instructor;
import com.bimarsh.hibernateEntity.InstructorDetail;

public class CreateInstructor {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//create object
			Instructor newInstructor = 
					new Instructor("Susan", "Vegas", "vegasSusan@hmail.com" );
			
			InstructorDetail newInstructorDetail = 
					new InstructorDetail(
							"https://www.youtube.com/watch?v=fv7lvY5Wci0&ab_channel=DimitriVegas%26LikeMike",
							"3 ARE LEGENDS!!!");
		
			// associate object --> Only in memory
			newInstructor.setInstructorDetail(newInstructorDetail);
			
			//start transaction
			session.beginTransaction();
			
			//save to database
			// since Cascade.ALL --> Applies to newInstructorDetail
			System.out.println("Saving Instructor: " + newInstructor);
			session.save(newInstructor);			
			
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
