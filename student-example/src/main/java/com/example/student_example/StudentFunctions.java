package com.example.student_example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentFunctions {
	static SessionFactory fact = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public void saveStudent(Student stu) {
    	Session session = fact.openSession();
        Transaction trans = session.beginTransaction();
        session.persist(stu);
        System.out.println("Student is being saved in db");
        trans.commit();
        session.close();
    }
    
    public Student retreiveStudent(int id) {
    	Session session = fact.openSession();
    	Transaction trans = session.beginTransaction();
    	Student stuRes = session.get(Student.class,id);
    	trans.commit();
    	session.close();
    	return stuRes;
    }
    
    public void updateStudent(String name, String email, int id) {
    	
    	Session session = fact.openSession();
    	Transaction trans = session.beginTransaction();
    	Student res = session.get(Student.class,id);
    	if(res!=null) {
    		res.setEmail(email);
    		res.setName(name);
    	}
    	session.persist(res);
    	System.out.println("Student details are updates");
    	trans.commit();
    	session.close();
    	}
    
    public void deleteStudent(int id) {
    	Session session = fact.openSession();
    	Transaction trans = session.beginTransaction();
    	Student res = session.get(Student.class,id);
    	if(res!=null) {
    		System.out.println("Student witht the name " + res.getName()+" is deleted");
    		session.remove(res);
    	}
    	System.out.println("Student details are removed");
    	trans.commit();
    	session.close();
    }
    
    public void end() {
    	fact.close();
    }
}
