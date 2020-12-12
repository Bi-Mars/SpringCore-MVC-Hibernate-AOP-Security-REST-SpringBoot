package com.bimarsh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bimarsh.hibernateEntity.Course;
import com.bimarsh.hibernateEntity.Instructor;
import com.bimarsh.hibernateEntity.InstructorDetail;
import com.bimarsh.hibernateEntity.Review;
import com.bimarsh.hibernateEntity.Student;

public class CreateCourseAndStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			//start transaction
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Learn DJ");
			
			//save the course ... 
			session.save(tempCourse);
			
			//create students
			Student student1 = new Student("John", "Doe", "johndoe@gmail.com");
			Student student2 = new Student("Fon", "Roe", "fonroe@gmail.com");
			Student student3 = new Student("Bimarsh", "Sharma", "bimarshsharma101@gmail.com");


			
			// add student to the course
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			tempCourse.addStudent(student3);

			
			// save the students
			session.save(student1);
			session.save(student2);
			session.save(student3);
		
			//commit transaction
			session.getTransaction().commit();

		}
		finally {
			//add clean up code
			session.close();
			factory.close();
		}

	}

}
