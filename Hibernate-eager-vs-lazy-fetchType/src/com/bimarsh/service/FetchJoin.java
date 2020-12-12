package com.bimarsh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bimarsh.hibernateEntity.Course;
import com.bimarsh.hibernateEntity.Instructor;
import com.bimarsh.hibernateEntity.InstructorDetail;

public class FetchJoin {

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
			// JOIN FETCH -> Joins the table and get all of the data at once
			Query<Instructor> query =
					session.createQuery("Select i from Instructor i " 
									+ "JOIN FETCH i.courses "
									+ "where i.id=:theInstructorId", 
							Instructor.class);
					
			//set parameter on query
			query.setParameter("theInstructorId", id);
			
			//execute query and get instructor
			Instructor instructor = query.getSingleResult();
		     System.out.println(" this is my code: " + instructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			//close the session:
			System.out.println("Closing session:\n");
			session.close();
			System.out.println("After closing session Courses:" + instructor.getCourses());


		}
		finally {
			//add clean up code
			session.close();
			factory.close();
		}

	}

}
