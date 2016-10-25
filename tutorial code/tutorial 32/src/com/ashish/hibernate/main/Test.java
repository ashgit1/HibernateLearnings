package com.ashish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("Ashish");
		
		 SessionFactory factory = HibernateUtil.getSessionFactory();
		 Session session = factory.openSession();
		 
		 session.beginTransaction();
		 session.save(user);
		 session.getTransaction().commit();
		 session.close();
		 
		 factory.close();
	
	}

}
