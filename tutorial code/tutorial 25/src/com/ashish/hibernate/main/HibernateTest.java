package com.ashish.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {

		

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from UserDetails where userId > 2");
		List<UserDetails> list  = (List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		session.close();		
		
		System.out.println("Table size : " + list.size());

	}

}
