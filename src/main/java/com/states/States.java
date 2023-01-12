package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hiber.Certificate;
import com.hiber.Student;

public class States {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 		Hibernates Objects States 
		 * 
		 * 		Transient
		 * 		Persistent
		 * 		Detached
		 * 		Removed					*/
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory();
		
		// creating student object
		Student student = new Student();
		student.setId(1302);
		student.setFirstName("java");
		student.setLastName("core");
		student.setEmail("core@java123.co");
		student.setCerti(new Certificate("java hibernate course" , "2 month"));
		
		
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(student);
		// student: persistent  -- session, database
		
		student.setFirstName("advanceJava");
		tx.commit();
		
		
		s.close();
		
		// student : Detached
		student.setFirstName("ABCC");
		System.out.println(student);
		
		f.close();
		
		
	}

}
