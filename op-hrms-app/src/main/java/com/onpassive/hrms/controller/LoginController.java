package com.onpassive.hrms.controller;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.onpassive.hrms.model.Employee;
import com.onpassive.hrms.model.User;
import com.onpassive.hrms.service.EmployeeService;
import com.onpassive.hrms.service.UserService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private EmployeeService employeeService;
	
	
	
	@PostMapping("loginprocess")
	public ResponseEntity<User> loginprocess(HttpServletRequest request,HttpServletResponse response,
			@RequestBody User user){
		Employee emp=null;
		
		String username=user.getUserName();
		String password=user.getUserPassword();
		//Encrpting password
		String encodedPassword=Base64.getEncoder().encodeToString(password.getBytes());
		System.err.println("encodedPassword in login>>>>>>>>>> "+encodedPassword); 
		
		try {
			User userFromDb=userService.validateUser(username,encodedPassword);
			System.err.println(userFromDb.getUserPassword());
			if(encodedPassword.equals(userFromDb.getUserPassword())) {
			emp=employeeService.findEmpByEmail(username);
			System.err.println("Welcome "+emp.getFirstName()+" to HRMS!!");
			//ModelAndView mv=new ModelAndView("login");
			return new ResponseEntity<>(HttpStatus.OK);
			}
		} 
		catch (Exception e) {
			System.err.println("Username or Password is wrong.");
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
		

		/*public static void main(String[] args) {
			
			String password="Rashmi123";
			int strength = 10; // work factor of bcrypt
			 BCryptPasswordEncoder bCryptPasswordEncoder =
			  new BCryptPasswordEncoder(strength, new SecureRandom());
			 String encodedPassword = bCryptPasswordEncoder.encode(password);
			 //bCryptPasswordEncoder.
			 System.err.println(encodedPassword);
			 
			 boolean isPasswordMatch = bCryptPasswordEncoder.matches(password, encodedPassword);
			 System.err.println(isPasswordMatch);
			 if(isPasswordMatch==true){
				 System.err.println("############");
			 }
			}*/

