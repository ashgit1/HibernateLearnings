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
		
		int userId=2;
		String userName="user3";
		
		Query query = session.getNamedQuery("UserDetails.byId");
		query.setInteger(0, userId);
		List<UserDetails> list = (List<UserDetails>) query.list();
		
		Query query2 = session.getNamedQuery("UserDetails.byName");
		query2.setString(0, userName);
		List<UserDetails> list2 = (List<UserDetails>) query2.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails user : list) {
			System.out.println("using named queries by hql user name is : " + user.getUserName());
		}
		
		for (UserDetails user : list2) {
			System.out.println("using named queries by sql user name is : " + user.getUserName());
		}
		

	}

}
