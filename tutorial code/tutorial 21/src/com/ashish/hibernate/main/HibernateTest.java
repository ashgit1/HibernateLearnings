package com.ashish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = null;

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		//  Create Operation... 
		System.out.println("========================== CREATE ==========================");
		for(int i=1; i<=10; i++){
			user = new UserDetails();
			user.setUserName("User" + i );
			session.save(user);
		}
		
		// Read Operation...
		System.out.println("========================== READ ==========================");
		for(int j=1; j<=10; j++){
			user = (UserDetails)session.get(UserDetails.class, j);
			System.out.println("Index: " + j +", User: " + user.getUserName());
		}
		
		// Update Operation...(Update user name of userId : 5)
		System.out.println("========================== UPDATE ==========================");
		user = (UserDetails)session.get(UserDetails.class, 5);
		System.out.println("User5 name before update : " + user.getUserName());
		user.setUserName("Ashish Gupta");
		session.update(user);
		System.out.println("User5 name after update  : " + user.getUserName());
		
		
		// Delete Operation...
		System.out.println("========================== DELETE ==========================");
		for(int k=6; k<=10; k++){
			user = (UserDetails)session.get(UserDetails.class, k);
			System.out.println("Deleting user with id: " + k);
			session.delete(user);
			System.out.println("Userid: " + k + " deleted");
		}
		
		session.getTransaction().commit();
		session.close();

	}

}
