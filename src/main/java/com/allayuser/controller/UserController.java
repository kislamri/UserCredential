package com.allayuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.allayuser.model.User;
import com.allayuser.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/signupUser")
	public User signupUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userObj = service.fetchUserByEmailId(tempEmailId);
			if(userObj !=null) {
				throw new Exception("user with " + tempEmailId + " is alrady exist");
			}
		}
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}

	
	 @PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		//If user present in database the login will successful
		//else throw the exception that user is not exist or Invalid credential.
		
		//Retrieve user Email id and password
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		
		User userObj = null;
		
		if(tempEmailId !=null & tempPass !=null) {
			userObj =service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
			
		}
		if (userObj == null) {
			throw new Exception("Invalid credentials!Please try again!");
		}
		return userObj("login Successfull");
	}


	private User userObj(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
