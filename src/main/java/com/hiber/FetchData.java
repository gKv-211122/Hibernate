package com.hiber;

import org.hibernate.cfg.Configuration;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

public class FetchData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// get, load
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");			
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		// get-student: 101
		Student student1 = (Student)session.get(Student .class, 101);	
		Student student2 = (Student)session.load(Student .class, 101);
		
		Address ad = (Address)session.get(Address.class, 1);
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(ad.getStreet() + " : " + ad.getCity());
		
		
		
		session.close();
		factory.close();
		
	}

}
