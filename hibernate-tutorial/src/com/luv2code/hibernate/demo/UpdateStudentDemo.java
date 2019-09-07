package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo
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
			
			int studentId = 1;
			
			// now get a new session and start a transaction
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			// retrieve student based on the id : primary key
			
			System.out.println("\n Getting student with id : "+studentId);
			
			Student myStudent = session.get(Student.class,studentId);
			
			System.out.println("Updating Student....");
			
			myStudent.setFirstName("washigtondc");
			
			
			// commit the transaction  
			
			session.getTransaction().commit();
			
			
			// NEW CODE 
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			// update email for all studnets
			
			System.out.println("Update email for all studnets");
			
			 session.createQuery("update Student set email='sendgvk@gmail.com'").executeUpdate();
			
			
			session.getTransaction().commit();
			
			System.out.println("commiting the transaction is done!!! ");
			
		} 
		finally 
		{
		
			factory.close();
		
		}
		
		
	}
}
