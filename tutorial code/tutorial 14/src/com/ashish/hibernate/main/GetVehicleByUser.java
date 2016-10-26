package com.ashish.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ashish.hibernate.util.HibernateUtil;

public class GetVehicleByUser {

	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		// get all the vehicles with userId = 1
		Query query = session.createQuery("select u.userId, u.userName, v.vehicleID, v.vehicleName "
											+ "from  UserDetails u, Vehicle v where u.userId = v.user and u.userId = 1");
		List<Object> result = query.list();
		System.out.println("# of vehicles of userId 1 : " + result.size());
		
		session.getTransaction().commit();
		session.close();
		
	}

}
