package com.masai;

import java.util.List;

public interface UserService {
	
	public User addUser(User user) throws UserException;
	
	public User updateUser(User user,String key) throws UserException;
	
	public User deleteUser(Integer userId,String key) throws UserException;
	
	public User viewUser(Integer userId,String key) throws UserException;
	
	public List<User> viewAllUsers(String key) throws UserException;
	
}
