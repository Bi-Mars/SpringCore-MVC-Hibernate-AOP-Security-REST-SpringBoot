package com.bimarsh.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			//get StudentID;
			int studentId = 1;
			
			// start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			Student myStudent = session.get(Student.class, studentId);
			
			//Update 
			System.out.println("Updating Student...");
			myStudent.setFirstName("Scooby");
			
			//commit
			session.getTransaction().commit();
			
			
			//More update
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students: Bulk Update 
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		
		finally {
			factory.close();
		}
	}

}
