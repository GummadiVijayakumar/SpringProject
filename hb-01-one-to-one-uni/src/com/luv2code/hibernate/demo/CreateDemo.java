package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo
{
	public static void main(String[] args) 
	{
		
		// create session factory
		
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .buildSessionFactory();
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try 
		{			
			// create the objects
			/*
			 * Instructor tempInstructor = new
			 * Instructor("viajy","gummadi","gummadi@luv2code.com");
			 * 
			 * InstructorDetail tempInstructorDetail = new
			 * InstructorDetail("gummadi Youtube Channel","horse racing");
			 */
			
			Instructor tempInstructor = new Instructor("nick","jhonas","priyankachopar@luv2life.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("PriyankaJhonas Youtube Channel","club and party");
			
			// associate the objects
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			
			session.beginTransaction();
			
			// save the instructor  
			
			// NOTE: this will also save the InstructorDetails Object Because of CascadeType.ALL
			
			System.out.println("Saving the Instructor : "+tempInstructor);
			
			session.save(tempInstructor);
			
			
			
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
