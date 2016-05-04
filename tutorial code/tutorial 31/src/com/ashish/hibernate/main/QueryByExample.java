package com.ashish.hibernate.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class QueryByExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Projections are used for aggregation functions like max(), count()...
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(UserDetails.class)
							.addOrder(Order.desc("userId"))
							;
		
		
		List<UserDetails> list = (List<UserDetails>) criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails user : list) {
			System.out.println("using criteria projection api, user name is : " + user.getUserName());
		}
	}
}
