package com.onpassive.hrms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@Column
	private int userRoleId;
	
	@Column
	private String userName;
	
	@Column
	private String userPassword;

	public User() {
		super();
	}
	
	
	
	

}
