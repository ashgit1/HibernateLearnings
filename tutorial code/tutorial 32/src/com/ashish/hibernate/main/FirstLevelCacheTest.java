package com.ashish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class FirstLevelCacheTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// First level within the same session.
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
		
		/**
		 * Some lines of code here...
		 */
		
		UserDetails user2 = (UserDetails) session.get(UserDetails.class, 5);

		session.getTransaction().commit();
		session.close();

		
	}
}
