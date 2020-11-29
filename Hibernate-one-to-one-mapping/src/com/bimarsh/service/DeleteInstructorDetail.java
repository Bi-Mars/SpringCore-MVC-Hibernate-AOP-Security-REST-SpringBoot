package com.bimarsh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Instructor;
import com.bimarsh.hibernateEntity.InstructorDetail;

public class DeleteInstructorDetail {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
				
			//start transaction
			session.beginTransaction();	
			
			//get instructor_detail object
			
			int instructorId = 2;
			
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, instructorId);
			
			//do something with received object
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			//do something with associated object
			System.out.println("the associated instructor: " +
							tempInstructorDetail.getInstructor());
			
			//delete Instructor Detail --> Cascades and deletes Instructor Object too
			session.delete(tempInstructorDetail);
			
			//commit transaction
			session.getTransaction().commit();

		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			//handle connection leak issue by closing session
			session.close();
			factory.close();
		}

	}

}
