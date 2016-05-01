package com.ashish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.Address;
import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {

		Address home = new Address();
		home.setCity("Mumbai");
		home.setState("Maharashtra");
		home.setStreet("Indra Lok");
		home.setPincode("400123");
		
		Address office = new Address();
		office.setCity("Banglalore");
		office.setState("Karnataka");
		office.setStreet("BTM");
		office.setPincode("401105");
		
		UserDetails user1 = new UserDetails();
		user1.setUserName("Ashish Gupta");
		user1.getListOfAdresses().add(home);
		user1.getListOfAdresses().add(office);
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.getTransaction().commit();
		session.close();
		
		// To get the user...
		
		UserDetails user = null;
		session = factory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("user name : " + user.getUserName());
		session.close();
		System.out.println("address size : " + user.getListOfAdresses().size());
		
	}

}
