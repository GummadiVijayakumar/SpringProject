package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForGummadiDemo
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		// create session factory
		
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Course.class)
									 .addAnnotatedClass(Review.class)
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try 
		{			
			
			// start a transaction
			
			session.beginTransaction();
			
			
			// get the student gummadi from the database
			
			int studentId = 1;
			
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("\n Loaded Student : "+tempStudent);
			
			System.out.println("Course : "+tempStudent.getCourses());
			
			// create more courses
			
			Course tempCourse1 = new Course("Java course : Head first");
			
			Course tempCourse2 = new Course("Java Pitfalls : Joshua Bloch");
			
			Course tempCourse3 = new Course("Complete Java : Herbert Shildt");
			
			
			
			// add student to courses 
			
			tempCourse1.addStudent(tempStudent);
			
			tempCourse2.addStudent(tempStudent);
			
			tempCourse3.addStudent(tempStudent);
			
			// save the courses 
			
			System.out.println("\n saving the course ");
			
			session.save(tempCourse1);		session.save(tempCourse2);  
			
			session.save(tempCourse3);
				
			
			//commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("commiting the transaction is done!!! ");
			
		} 
		finally 
		{
			// add clean up code
			
			session.close();
			
			factory.close();
		
		}
		
		
	}
}
