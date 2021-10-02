package com.allayuser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.allayuser.model.User;
import com.allayuser.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User fetchUserByEmailId(String email) {
		return userRepository.findByEmailId(email);
	}

	public User fetchUserByEmailIdAndPassword(String email, String password) {
		return userRepository.findByEmailIdAndPassword(email, password);
	}

}
