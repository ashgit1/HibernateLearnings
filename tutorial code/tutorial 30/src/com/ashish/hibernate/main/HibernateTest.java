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
		/*criteria.add(Restrictions.gt("userId", 5))
				.add(Restrictions.eq("userName", "user10"))
		;*/

		/*criteria.add(Restrictions.like("userName", "%user1%"))
		.add(Restrictions.between("userId", 5, 20))
		;*/
		// or Restrictions
		criteria.add(Restrictions.or(
									Restrictions.between("userId", 1, 3), 
									Restrictions.between("userId", 5,8))
									);
		
		List<UserDetails> crlist = (List<UserDetails>) criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails user : crlist) {
			System.out.println("using criteria api, user name is : "
					+ user.getUserName());
		}
	}
}
