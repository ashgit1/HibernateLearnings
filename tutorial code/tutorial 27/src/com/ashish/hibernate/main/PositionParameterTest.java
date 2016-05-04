package com.ashish.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class PositionParameterTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// To prevent SQL injection by parameter substitution (?)
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		//String userId = "5 or 1=1 "; 
		//this throws Exception in thread "main" java.lang.NumberFormatException: For input string: "5 or 1=1 "
		String userId = "5";
		Query query = session.createQuery("from UserDetails where userId > ?");
		query.setInteger(0, Integer.parseInt(userId));
		
		List<UserDetails> list = (List<UserDetails>) query.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails user : list) {
			System.out.println("user name is " + user.getUserName());
		}

	}

}
