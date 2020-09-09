/*
 * Copyright 2020 ONPASSIVE AI Company 
 * All Rights Reserved.
 * No portions of this source code or the resulting compiled program may be
 * used without express written consent and licensing by ONPASSIVE
 */

package com.onpassive.hrms.service;

import javax.servlet.Registration;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onpassive.hrms.model.Employee;
import com.onpassive.hrms.model.User;
import com.onpassive.hrms.repository.EmployeeRepository;
import com.onpassive.hrms.repository.UserRepository;

/**
 * This class has the service implementation for Employee Entity.
 * @author Rashmiranjan
 *
 */

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;

	public Iterable<Employee> getAllEmployeesDetails() {
		return employeeRepository.findAll();
	}
	
	public void addEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	public Employee getEmployeeById(long empId) {
		return employeeRepository.findById(empId).get();
	}

	public void deleteEmployeeById(long empId) {
		employeeRepository.deleteById(empId);
	}

	public void updateEmployeeById(long empId, Employee emp) {
		employeeRepository.save(emp);
	}
	
	public Employee findEmpByEmail(String emailId) {
		return employeeRepository.findEmpByEmail(emailId);
		
	}
	
	public Employee userRegd(@Valid Employee emp) {
		//System.err.println("################"+emp.getUser_password()+" "+emp.getEmail_id());
		Employee empInsert=null;
		User userInt=null;
		if(emp!=null) {
			empInsert=new Employee();
			userInt=new User();
			//emp1.setEmp_id(emp.getEmp_id());
			empInsert.setFirstName(emp.getFirstName());
			empInsert.setLastName(emp.getLastName());
			empInsert.setGender(emp.getGender());
			empInsert.setEmailId(emp.getEmailId());
			empInsert.setJoiningDate(emp.getJoiningDate());
			empInsert.setDateOfBirth(emp.getDateOfBirth());
			empInsert.setLocation(emp.getLocation());
			empInsert.setPhotoPath(emp.getPhotoPath());
			userInt.setUserName(emp.getEmailId());
			userInt.setUserPassword(emp.getUserPassword());			
			employeeRepository.save(empInsert);			
			userRegdd(emp.getEmailId(),emp.getUserPassword());
		}
		return empInsert;
		
	}
	
	public void userRegdd(String email,String pwd) {
		//System.err.println("################"+email+" "+pwd+"########");		
		User userInt=null;
		if(email!=null) {			
			userInt=new User();			
			userInt.setUserName(email);
			userInt.setUserPassword(pwd);
			userRepository.save(userInt);			
		}
	}
	
	
	
}

