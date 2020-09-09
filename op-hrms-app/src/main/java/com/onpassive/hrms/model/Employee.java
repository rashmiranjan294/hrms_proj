/*
 * Copyright 2020 ONPASSIVE AI Company 
 * All Rights Reserved.
 * No portions of this source code or the resulting compiled program may be
 * used without express written consent and licensing by ONPASSIVE
 */

package com.onpassive.hrms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * This is the entity class for storing employee information
 * 
 * @author Rashmiranjan
 *
 */

@Entity
@Table(name="employee")
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String emailId;
	
	@Column
	private String gender;
	
	@Column
	private Date dateOfBirth;
	
	@Column
	private Date joiningDate;
	
	@Column
	private int deptId;
	
	@Column
	private int managerId;
	
	@Column
	private String photoPath;
	
	@Column
	private String location;
	
	@Column
	private int contactdetailsId;
	
	@Column
	private String userPassword;
	
	public Employee() {
		super();
	}
		
}
