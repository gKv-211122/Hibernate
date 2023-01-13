package com.pagination;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiber.Student;

public class HQLpegination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session s = f.openSession();
		
		// we can also use it, 
		// Query<Student> query = s.createQuery("from Student", Student.class);
		
		Query query = s.createQuery("from Student");
		
		// implementation pegination using hibernate
		
		query.setFirstResult(0);
		
		query.setMaxResults(3);
		
		List<Student> list = query.getResultList();
		
		for(Student st : list) {
			
			System.out.println(st.getId()+" : "+ st.getFirstName() + " : " + st.getLastName());
		}
		
		
		
		s.close();
		f.close();
	}

}
