package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingMtM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(123);
		e1.setName("ram");
		e2.setEid(111);
		e2.setName("shayam");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(123213);
		p1.setProjectName("LMS in java");
		p2.setPid(454555);
		p2.setProjectName("web application");
		
		List<Emp> elst = new ArrayList<Emp>();
		List<Project> plst = new ArrayList<Project>();
		
		elst.add(e1);
		elst.add(e2);
		
		plst.add(p1);
		plst.add(p2);
		
		//
		e1.setProjects(plst);
		p1.setEmps(elst);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
	
		factory.close();
	}

}
