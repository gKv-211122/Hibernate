package com.map;

import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Maping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating question
		Question q1 = new Question();
		q1.setQuestionId(121);
		q1.setQuestion("What is java ?");

		// creating answer
		Answer answer = new Answer();
		answer.setAnswerId(101);
		answer.setAnswer("java is Oops programming language");
		answer.setQuestion(q1);
		
		Answer answer1 = new Answer();
		answer1.setAnswerId(111);
		answer1.setAnswer("Java is platform independent language");
		answer1.setQuestion(q1);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(121);
		answer2.setAnswer("we can devlope softwares with help of java");
		answer2.setQuestion(q1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		q1.setAnswer(list);
	
		
		

		
		// session
		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();

		// save
//		s.save(q1);
//		s.save(answer);
//		s.save(answer1);
//		s.save(answer2);
		
		
		Question q = (Question)s.get(Question.class, 121);
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		
		// Lazy loading - we have to call, by default it's Lazy
//		System.out.println(q.getAnswer().size());
//		
//		for(Answer ans : q.getAnswer()) {
//			
//			System.out.println(ans.getAnswer());
//		}
		
//		Question q = (Question)s.get(Question.class, 121);
//		System.out.println(q.getQuestionId());
//		System.out.println(q.getQuestion());

		tx.commit();

		
		// System.out.println(newQ.getAnswer().getAnswer());
		
		s.close();
		factory.close();
	}

}
