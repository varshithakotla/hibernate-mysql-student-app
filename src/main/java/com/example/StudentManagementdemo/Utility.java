package com.example.StudentManagementdemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Utility {
private static SessionFactory sessionFactory;
static {
	try {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
public static SessionFactory getSessionFactory(){
	return sessionFactory;
}
	
}

