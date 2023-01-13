package com.hql;



import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hiber.Student;

public class HQLExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		// HQL 
		// Syntax:
		// static value
		// String query = "from Student where id ='1223'";
		
		// dynamic value
		//String query = "from Student where id =:x";
		String query = "from Student as s where s.id =:x and s.firstName=:y";
		// oject based , work on query
		
		Query q = s.createQuery(query);
		q.setParameter("x", 122);
		q.setParameter("y", "AAA");
		
		
		// single - (Unique)
		// multiple-list
		List<Student> list=q.getResultList();
		
		for(Student student: list) {
			
			System.out.println(student.getFirstName() + " : " + student.getLastName());
			System.out.println(student.getCerti().getCourse());
			System.out.println(student.getCerti().getDuration());
		}
		
		System.out.println("-------------------------------------------------------");
		
		Transaction tx = s.beginTransaction();
		
		/* delete query */
//		Query q2 = s.createQuery("delete from Student s where s.firstName=:x");
//		q2.setParameter("x", "java");
//		int r = q2.executeUpdate();
//		System.out.println("deleted");
//		System.out.println(r);
		
		
		/* update query */
		Query q2 = s.createQuery("update Student set firstName=:f where id=:x");
		q2.setParameter("f", "DDD");
		q2.setParameter("x", 1302);
		int r = q2.executeUpdate();
		
		System.out.println(r + " object updated");
		
		tx.commit();
		
		// how to execute join query
		Query q3 = s
				.createQuery("select q.question, q.questionId, a.answer from Question as q INNER JOIN q.answer as a");
				
				
		List<Object[]> lst = q3.getResultList();
		for(Object [] arr : lst) {
			
			System.out.println(Arrays.toString(arr));
		}
		
		
		s.close();
		factory.close();
	}

}
