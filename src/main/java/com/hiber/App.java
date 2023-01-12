package com.hiber;

import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.openSession();

		System.out.println(session);

		try {

			// create a student object
			Student s = new Student();

			s.setId(101);
			s.setFirstName("java8");
			s.setLastName("JEE");
			s.setEmail("com.131@.co");
			
			
			// create address object
			Address ad = new Address();
			
			ad.setStreet("street3");
			ad.setCity("New Delh");
			ad.setOpen(true);
			ad.setAddedDate(new Date());
			ad.setX(113.535);
			FileInputStream fis = new FileInputStream("src/main/java/bimg.jpg");
			
//			byte [] img = new byte [fis.available()];
//			fis.read(img);
//			
//			ad.setImage(img);
			
			
			// start a transaction
			session.beginTransaction();  // when we have to save data

			// save the student object
			session.save(s);
			session.save(ad);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("program run...");

			System.out.println(s.toString());

		} catch (Exception exc) {

			exc.printStackTrace();
		} finally {

			System.out.println("Executed Successfully...");
			session.close();
		}

	}
}
