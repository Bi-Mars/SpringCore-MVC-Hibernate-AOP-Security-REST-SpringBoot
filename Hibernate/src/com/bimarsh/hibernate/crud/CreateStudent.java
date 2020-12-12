package com.bimarsh.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			//create a student object
			System.out.println("Creating new Student object ...");
			Student newStudent = new Student("Bimarsh", "Sharma", "bimarshsharma101@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student...");
			session.save(newStudent);
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		
		finally {
			factory.close();
		}
	}

}
