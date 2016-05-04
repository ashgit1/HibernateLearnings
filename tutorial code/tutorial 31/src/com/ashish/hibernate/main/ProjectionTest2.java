package com.ashish.hibernate.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class ProjectionTest2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		UserDetails exampleUser = new UserDetails();
		exampleUser.setUserName("user1%");
		
		//Example example = Example.create(exampleUser).excludeProperty("userName");
		Example example = Example.create(exampleUser).enableLike();
		
		Criteria criteria = session.createCriteria(UserDetails.class)
									.add(example);
		
		List<UserDetails> list = (List<UserDetails>) criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails user : list) {
			System.out.println("using criteria example api, user name is : " + user.getUserName());
			System.out.println("using criteria example api, user id is : " + user.getUserId());
			System.out.println("-------------------------------------------------------------------");
		}
	}
}
