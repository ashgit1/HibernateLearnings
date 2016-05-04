package com.ashish.hibernate.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class HibernateTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userName", "user10"));

		List<UserDetails> crlist = (List<UserDetails>) criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails user : crlist) {
			System.out.println("using criteria api, user id is : "
					+ user.getUserId());
		}
	}
}
