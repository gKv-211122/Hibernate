package com.hiber;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;


public class CreateStudentDemo {
	
	public static void main(String [] args) {
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
								 
		// create session
		 Session session = factory.openSession();
		 
		 
		 System.out.println(session);
		 
		 try {
			 // create a student object
			 Student s = new Student();
			 
			 s.setId(104);
			 s.setFirstName("javaEE");
			 s.setLastName("JEE");
			 s.setEmail("com.1253@.co");
			 
			 
			 // start a transaction
			 session.beginTransaction();
			 
			 // save the student object
			 session.save(s);
			 
			 // commit transaction
			 session.getTransaction().commit();
			 
			 System.out.println("program run...");
			 
			 System.out.println(s.toString());
		 }
		 catch(Exception exc) {
			 
			 exc.printStackTrace();
		 }
		 finally {
			 
			System.out.println("Executed Successfully...");
			session.close();
		}
								 
	}
}
