package com.bimarsh.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Student;

public class QueryStudent {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {					
			// start a transaction
			session.beginTransaction();
			
			//query Students
			List<Student> studentList = session.createQuery("from Student").getResultList();
			
			displayStudents(studentList);
			
			
			// query students : whose last name is "Doe"
			studentList = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			System.out.println("\n\n Students who have last name of Doe");
			displayStudents(studentList);
			
			// query students: whose last name is Doe OR firstName = 'paul'
			studentList = session.createQuery("from Student s where" 
									+ " s.lastName='Doe' OR s.firstName='paul'").getResultList();
			
			System.out.println("\n\n whose last name is Doe OR firstName = 'paul'");
			displayStudents(studentList);
			
			// query Students: LIKE predicate whose email ends with @gmail.com
			studentList = session.createQuery("from Student s where" 
										+ " s.email LIKE '%gmail.com'").getResultList();
			System.out.println("\n\n LIKE predicate whose email ends with @gmail.com");
			displayStudents(studentList);

			

			//commit
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> studentList) {
		//display students
		for(Student eachStudent : studentList) {
			System.out.println(eachStudent.toString());
		}
	}

}
