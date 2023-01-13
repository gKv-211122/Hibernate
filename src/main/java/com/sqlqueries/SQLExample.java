package com.sqlqueries;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
		// SQL Query
		String q = "select * from student";
		NativeQuery nq = session.createSQLQuery(q);
		
		List<Object []> lst = nq.list();
		
		for(Object [] s : lst) {
			
			System.out.println(Arrays.toString(s));
		}
		
		session.close();
		factory.close();
	}
}
