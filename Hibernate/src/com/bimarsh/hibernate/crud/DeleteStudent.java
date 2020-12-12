package com.bimarsh.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Student;

public class DeleteStudent {

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
			
			//delete the Student with ID=1
			System.out.println("\n\n Deleting Student: " + myStudent.toString());
			session.delete(myStudent);
			
			//commit
			session.getTransaction().commit();			
			
			//Delete without retrieving Object
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//delete student without retrieving Object
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			//commit
			session.getTransaction().commit();			
			
			System.out.println("Done!");
		}
		
		finally {
			factory.close();
		}
	}

}
