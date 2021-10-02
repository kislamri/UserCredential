package com.allayuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allayuser.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{



	public User findByEmailIdAndPassword(String emailId, String password);

	public User findByEmailId(String emailId);

}
