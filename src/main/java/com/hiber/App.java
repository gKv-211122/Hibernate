package com.hiber;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
       
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        System.out.println(factory);
        
//        Student s = new Student();
//        
//        s.setId(101);
//        s.setFirstName("core");
//        s.setLastName("java");
//        s.setEmail("core@java.co");
//        
//        
//        Session session=factory.openSession();
//        Transaction tx=session.beginTransaction();
//        session.save(s);
//
//        tx.commit();
//
//        session.close();
        
        
        
       
      


        
        
    }
}
