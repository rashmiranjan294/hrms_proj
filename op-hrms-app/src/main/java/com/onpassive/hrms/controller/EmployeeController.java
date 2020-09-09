/*
 * Copyright 2020 ONPASSIVE AI Company 
 * All Rights Reserved.
 * No portions of this source code or the resulting compiled program may be
 * used without express written consent and licensing by ONPASSIVE
 */

package com.onpassive.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onpassive.hrms.model.Employee;
import com.onpassive.hrms.service.EmployeeService;

/**
 * This is controller class from Employee Entity
 * 
 * @author Rashmiranjan
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getAll")
	public ResponseEntity<Iterable<Employee>> getAllEmployeesDetails(){
		Iterable<Employee> list = employeeService.getAllEmployeesDetails();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployeesDetails(@RequestBody Employee emp){
		employeeService.addEmployee(emp);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getOne/{empId}")
	public ResponseEntity<Employee> getEmployeesById(@PathVariable("empId") long empId){
		Employee getEmp=employeeService.getEmployeeById(empId);
		return new ResponseEntity<>(getEmp,HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable("empId") long empId,
			@RequestBody Employee emp) {
		employeeService.updateEmployeeById(empId, emp);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("empId") long empId){
		employeeService.deleteEmployeeById(empId);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	/* @PostMapping("/signup")
	public ResponseEntity<Employee> employeeRegistration(@RequestBody@Valid Employee emp,BindingResult result){
		Employee existingEmail=null;
		System.err.println(">>>>>>>>>>>>>"+emp.getEmail_id());
		String inputEmail=emp.getEmail_id();
		//if
		try {
		existingEmail=employeeService.findEmpByEmail(inputEmail);
		if(inputEmail.equals(existingEmail.getEmail_id())) {
			System.err.println("Email_id already exist.");
			return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		catch(Exception e){
			//emp.s
			employeeService.userRegd(emp);
			System.err.println("Registration successful..");
		}
		
		return new ResponseEntity<>(HttpStatus.OK); 
		
		
	}*/

}
