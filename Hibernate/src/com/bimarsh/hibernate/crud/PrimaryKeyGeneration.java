package com.bimarsh.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Student;

public class PrimaryKeyGeneration {
	
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			//create 3 student objects
			System.out.println("Creating 3 Student object ...");
			Student newStudent1 = new Student("John", "Doe", "johndoe@gmail.com");
			Student newStudent2 = new Student("Option", "Alpha", "optionalpha1@gmail.com");
			Student newStudent3 = new Student("Paul", "Wall", "paul@luv2code.com");

			
			// start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Students...");
			session.save(newStudent1);
			session.save(newStudent2);
			session.save(newStudent3);

			
			//commit
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		
		finally {
			factory.close();
		}
	}

}
