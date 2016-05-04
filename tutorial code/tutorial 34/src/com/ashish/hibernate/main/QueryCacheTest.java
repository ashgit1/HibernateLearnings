package com.ashish.hibernate.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.util.HibernateUtil;

public class QueryCacheTest {

	public static void main(String[] args) {

		// Second level cache.

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from UserDetails where userId = 3");
		query.setCacheable(true);
		query.list();

		session.getTransaction().commit();
		session.close();

		// Another Session to get the same object...

		Session session2 = factory.openSession();
		session2.beginTransaction();

		Query query2 = session2.createQuery("from UserDetails where userId = 3");
		query2.setCacheable(true);
		query2.list();

		session2.getTransaction().commit();
		session2.close();

	}
}
