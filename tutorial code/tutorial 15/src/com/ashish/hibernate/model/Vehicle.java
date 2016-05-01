package com.ashish.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@Column(name = "VEHICLE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleID;

	@Column(name = "VEHICLE_NAME")
	private String vehicleName;

	@ManyToMany(mappedBy="vehicle")
	private Collection<UserDetails> user = new ArrayList<UserDetails>();

	public Collection<UserDetails> getUser() {
		return user;
	}

	public void setUser(Collection<UserDetails> user) {
		this.user = user;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
