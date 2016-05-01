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
		
		UserDetails user1 = new UserDetails();
		user1.setUserName("Ashishkumar Gupta");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("Tanya Sethi");
		
		user1.getVehicle().add(vehicle1);
		user1.getVehicle().add(vehicle2);

		user2.getVehicle().add(vehicle2);
		
		vehicle1.getUser().add(user1);
		vehicle2.getUser().add(user1);
		
		vehicle2.getUser().add(user2);		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
		/**
		 * Use the below query to fetch from the tables created.
		 * select u.user_id, u.user_name, v.vehicle_id, v.vehicle_name 
		 * from user_details u, vehicle v, user_vehicle uv
		 * where u.user_id = uv.user_id and v.vehicle_id = uv.vehicle_id;
		 */
	}

}
