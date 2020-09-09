package com.onpassive.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onpassive.hrms.model.User;
import com.onpassive.hrms.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User validateUser(String user_name,String encodedPassword) {
		return userRepository.login(user_name,encodedPassword);
		
		 
		
	}
	
	}
