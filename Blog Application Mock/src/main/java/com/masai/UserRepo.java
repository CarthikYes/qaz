package com.masai;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByUserName(String username);
}
