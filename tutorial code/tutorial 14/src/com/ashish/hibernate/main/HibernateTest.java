package com.ashish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.UserDetails;
import com.ashish.hibernate.model.Vehicle;
import com.ashish.hibernate.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Bugati Veyron");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Ferrari");
		
		UserDetails user = new UserDetails();
		user.setUserName("Ashishkumar Gupta");
		
		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);

		vehicle1.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();

	}

}
