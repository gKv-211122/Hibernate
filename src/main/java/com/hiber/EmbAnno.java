package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbAnno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			// student class object
			Student student1 = new Student();
			student1.setId(129);
			student1.setFirstName("AAA");
			student1.setLastName("aaa");
			student1.setEmail("aaa.123@.co");
			
			// certificate classs object
			Certificate cr = new Certificate();
			cr.setCourse("java");
			cr.setDuration("4 Months");
			student1.setCerti(cr);
			
			Student student2 = new Student();
			student2.setId(111);
			student2.setFirstName("BBB");
			student2.setLastName("bbb");
			student2.setEmail("bbb.123@.co");
			
			Certificate cr1 = new Certificate();
			cr1.setCourse("Adv. java");
			cr1.setDuration("2 Months");
			student2.setCerti(cr1);
			
			Session session = factory.openSession();
			
			session.beginTransaction();
			
			// object save
			session.save(student1);
			session.save(student2);
			
			session.getTransaction().commit();
			
			
			session.close();
			factory.close();
			
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
			
		}
		finally {
			System.out.println("Executed...");
			
			
		}

	}

}
