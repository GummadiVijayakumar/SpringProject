package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo
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
			
			// get the instructor detail object
			
			int theId = 6;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class  ,  theId);
			
			// print the instructor detail object
			
			System.out.println("temp instructor Detail : "+tempInstructorDetail);
			
			// print the associated instructor object
			
			System.out.println("The associated instructor inside the instructordetail object :  "+tempInstructorDetail.getInstructor());
			
			// now let's delete the instructordetail 
			
			System.out.println("Deleting the  tempInstructorDetail : "+tempInstructorDetail);
			
			// remove the associated object reference
			// break bi-directional link
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			//commit transaction
			
			session.getTransaction().commit();
			
			System.out.println("commiting the transaction is done!!! ");
			
		} 
		
		catch (Exception exc)
		{
			exc.printStackTrace();
			
		}
		
		finally 
		{
			// handle connection leak issue  
			
			session.close();
		
			factory.close();
		
		}
		
		
	}
}
