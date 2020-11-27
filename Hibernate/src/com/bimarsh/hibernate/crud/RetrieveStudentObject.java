package com.bimarsh.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Student;

public class RetrieveStudentObject {

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
			Student newStudent = new Student("Donald", "Duck", "makeamaericagreatagain@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student...");
			session.save(newStudent);
			
			//commit
			session.getTransaction().commit();
			
			
			//Retrieve object from database: FIND PRIMARY KEY
			System.out.println("Saved student: generated id :- " + newStudent.getId());
			
			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the ID: Primary key
			System.out.println("\n Geting student wth id: " + newStudent.getId());
			int primaryKey = newStudent.getId();
			Student myStudent = session.get(Student.class, primaryKey);
			System.out.println("Get complete: " + myStudent.toString());
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		
		finally {
			factory.close();
		}
	}

}
