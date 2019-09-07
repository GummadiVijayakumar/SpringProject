package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo
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
			
			// create a 3 student objects
			
			System.out.println("creating a new student object ...");
			
			Student tempStudent1 = new Student("nick","jhonas","jhonas@luv2code.com");
			
			Student tempStudent2 = new Student("elisha","cuthbert","cuthbert@luv2code.com");
			Student tempStudent3 = new Student("morgan","freeman","freeman@luv2code.com");

			// start a transaction
			
			session.beginTransaction();
			
			// save the student object
			
			System.out.println("saving the student object...");
			
			session.save(tempStudent1);
			
			session.save(tempStudent2);
			
			session.save(tempStudent3);
			
			//commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("commiting the transaction is done!!! ");
			
		} 
		
		
		finally 
		{
		
			factory.close();
		
		}
		
	}
}
