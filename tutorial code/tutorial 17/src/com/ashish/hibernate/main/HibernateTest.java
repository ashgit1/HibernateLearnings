package com.ashish.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ashish.hibernate.model.FourWheeler;
import com.ashish.hibernate.model.TwoWheeler;
import com.ashish.hibernate.model.Vehicle;
import com.ashish.hibernate.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Vehicle");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("R15");
		bike.setSteeringHandle("R15 Steering Handle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche Steering Wheel");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();

	}

}
