package com.ashish.hibernate.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}