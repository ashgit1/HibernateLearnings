package com.ashish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {

		// Transient state...
		UserDetails user = new UserDetails();
		user.setUserName("Ashish User");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		// Persisted state...
		session.save(user);
		
	    user.setUserName("User name updated");
	    user.setUserName("User name updated Again");
	    
	    // hb tracks this persisted object and therefore will consider the last update...
		
		session.getTransaction().commit();
		session.close();
		
		// Detached state...
		user.setUserName("update user name after session is closed.");

	}

}
