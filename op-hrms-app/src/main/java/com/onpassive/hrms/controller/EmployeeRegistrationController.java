package com.onpassive.hrms.controller;

import java.util.Base64;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onpassive.hrms.model.Employee;
import com.onpassive.hrms.service.EmployeeService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
public class EmployeeRegistrationController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/signup")
	public ResponseEntity<Employee> employeeRegistration(@RequestBody @Valid Employee emp,BindingResult result){
		Employee existingEmail=null;
		System.err.println(">>>>>>>>>>>>>"+emp.getEmailId());
		String inputEmail=emp.getEmailId();
		try {
		existingEmail=employeeService.findEmpByEmail(inputEmail);
		if(inputEmail.equals(existingEmail.getEmailId())) {
			System.err.println("Email_id already exist.");
			return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		catch(Exception e){
			//Encrypting password
			String password=emp.getUserPassword();
			String encodedPassword=Base64.getEncoder().encodeToString(password.getBytes());
			System.err.println("encodedPassword>>>>>>>>>> "+encodedPassword);
           
            //inserting records
            emp.setUserPassword(encodedPassword);
            employeeService.userRegd(emp);
			System.err.println("Registration successful..");
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
		
		
	}

}
