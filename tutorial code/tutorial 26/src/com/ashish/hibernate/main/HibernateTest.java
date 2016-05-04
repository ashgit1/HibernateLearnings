package com.ashish.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class HibernateTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from UserDetails");
		query.setFirstResult(2);
		query.setMaxResults(3);
		
		List<UserDetails> list = (List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		session.close();		
		
		for(UserDetails user : list){
			System.out.println("user name: " + user.getUserName());
		}
	}

}
