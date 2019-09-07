package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo
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
			
			int studentId = 7;
			
			// now get a new session and start a transaction
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			// retrieve student based on the id : primary key
			
			System.out.println("\n Getting student with id : "+studentId);
			
			Student myStudent = session.get(Student.class,studentId);
			
			// delete the stduent
			
			System.out.println("Deleting Student :"+myStudent);
			
			session.delete(myStudent);
			
			// delete student id = 2
			
			System.out.println("Deleting student with id = 2 using alternate approach");
			
			session.createQuery("delete from Student where id = 2").executeUpdate();
			
			// commit the transaction  
			
			session.getTransaction().commit();
			
			System.out.println("commiting the transaction is done!!! ");
			
		} 
		finally 
		{
		
			factory.close();
		
		}
		
		
	}
}
