package com.bimarsh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Instructor;
import com.bimarsh.hibernateEntity.InstructorDetail;

public class DeleteInstructor {

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
			
			//in order to delete we need to get to that tuple. How? Primary Key
			int instructorId = 1;
			Instructor tempInstructor =
					session.get(Instructor.class, instructorId);
			
			//delete the instructors 
			if(tempInstructor != null ) {
				
				//NOTE: Also deletes instructor_details because of Cascading properties
				session.delete(tempInstructor);
			}
			else {
				System.out.println("Instructor with provided ID does not exist");
			}
			
			//commit transaction
			session.getTransaction().commit();

		}
		finally {
			factory.close();
		}

	}

}
