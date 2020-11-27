package com.bimarsh.hibernate.employeeCRud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernate.employeeEntity.Employee;

public class CreateReadEmployee {

	public static void main(String[] args) {

		//Tell Hibernate about configuration file and create SessionFactory
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
				
		//create session:
			Session session = factory.getCurrentSession();
			
		try {
		
		// Begin transaction
		session.beginTransaction();
		
		//Create Employee Object
		Employee employee = new Employee(2, "John","Smith", "WVU TECH");
		
		//create tuple in database
		session.save(employee);
		
		//commit transaction
		session.getTransaction().commit();
		
		//Retrieve data using primary key
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//retrieve Object
		Employee employeeRetrieve = session.get(Employee.class, 1);
		System.out.println(employeeRetrieve.toString());
		
		}
		finally {
			factory.close();
		}
		
		
	}
	

	

}
