package com.ashish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class SecondLevelCacheTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// Second level cache.

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);

		session.getTransaction().commit();
		session.close();

		// Another Session to get the same object...

		Session session2 = factory.openSession();
		session2.beginTransaction();

		UserDetails user2 = (UserDetails) session2.get(UserDetails.class, 5);

		session2.getTransaction().commit();
		session2.close();

	}
}
