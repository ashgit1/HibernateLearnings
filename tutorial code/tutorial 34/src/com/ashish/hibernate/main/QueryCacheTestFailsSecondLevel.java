package com.ashish.hibernate.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class QueryCacheTestFailsSecondLevel {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// Second level cache.

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Query query =  session.createQuery("from UserDetails u where u.userId = 2 ");
		List user = query.getResultList();

		session.getTransaction().commit();
		session.close();

		// Another Session to get the same object...

		Session session2 = factory.openSession();
		session2.beginTransaction();

		Query query2 =  session2.createQuery("from UserDetails u where u.userId = 2 ");
		user = query2.getResultList();

		session2.getTransaction().commit();
		session2.close();

	}
}
