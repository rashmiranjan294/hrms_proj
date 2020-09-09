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
	@Column(name="emp_id")
	private long empId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="joining_date")
	private Date joiningDate;
	
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="manager_id")
	private int managerId;
	
	@Column(name="photo_path")
	private String photoPath;
	
	@Column(name="location")
	private String location;
	
	@Column(name="contactdetails_id")
	private int contactdetailsId;
	
	private String userPassword;
	
	
	public Employee() {
		super();
	}
		
}
