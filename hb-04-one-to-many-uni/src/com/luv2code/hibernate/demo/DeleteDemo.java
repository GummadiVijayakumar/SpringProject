package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo
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
			// start a transaction
			
			session.beginTransaction();
			
			// get the instructor by primary key or id 
			
			int theId = 1;
			
			Instructor tempInstructor = session.get(Instructor.class , theId);
			
			System.out.println("Found Instructor : "+tempInstructor);
			
			// delete the instructor
			
			if(   tempInstructor != null  )
			{
				
				System.out.println("Deleting :  "+tempInstructor);
				
				// Note: it will also delete associated instructordetails object because of CascadeType.ALL
				
				session.delete(tempInstructor);
				
			}
			
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
