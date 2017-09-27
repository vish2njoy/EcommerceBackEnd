package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO 
{
	public boolean addUser(User user);
	public List<User> getAllUsers();
	public User getUserById(String username);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
		
}
