package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo
{
	public static void main(String[] args) 
	{
		
		// create session factory
		
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try 
		{
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students 
			
			displayStudents(theStudents);
			
			// query students : lastname = 'jhonas'
			
			theStudents = session.createQuery("from Student where lastName='jhonas'").getResultList();
			
			// display the students with lastname = 'jhonas'
			
			System.out.println("\n \nStduents who have lastname of jhonas");
			
			displayStudents(theStudents);
			
			// query students with lastName='cuthbert' OR firstName='morgan'
			
			theStudents = session.createQuery("from Student where lastName='cuthbert' OR firstName='morgan'").getResultList();
			
			//  display the students with lastName='cuthbert' OR firstName='morgan'
			
			System.out.println("\n \nStduents who have lastname of cuthbert and also firstName='morgan'");
			
			displayStudents(theStudents);	
			
			// query students where email LIKE '%luv2code.com'
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();
			
			//  display the students where email LIKE '%luv2code.com'
			
			System.out.println("\n \nStduents who havewhere email LIKE '%luv2code.com'");
					
			displayStudents(theStudents);	
			
			// query students where email LIKE '%gamil.com'
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
						
			//  display the students where email LIKE '%luv2code.com'
						
			System.out.println("\n \nStduents who havewhere email LIKE '%gmail.com'");
								
			displayStudents(theStudents);	
					
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("commiting the transaction is done!!! ");
			
		} 
		finally 
		{
			factory.close();
		
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student stu : theStudents )
		{
			System.out.println(stu);
		}
	}
}
