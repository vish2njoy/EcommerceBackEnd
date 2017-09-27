package com.niit.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserTestCase 
{

	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		

		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit");
		annotationConfigAppContext.refresh();
		userDAO=(UserDAO)annotationConfigAppContext.getBean("userDAO");
		System.out.println("test");
	}
	
	// Adding new User
	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setUsername("Abhi");
		user.setPassword("12345");
		user.setCustName("Abhijith");
		user.setRole("User");
		user.setMobile("1234567890");
		user.setUsernickname("Abhi");
		assertTrue("Problem in Adding user",userDAO.addUser(user));
	}
	
	//Getting the details
	@Test
	public void getAllUserTestCase()
	{
		List<User> listUsers=userDAO.getAllUsers();
		assertTrue("No Users",listUsers.size()>0);
	}
	
	// Getting the user details
	@Test
	public void getUser()
	{
		String username = "Abhi";
		User user = userDAO.getUserById(username);
		Assert.assertNotNull("User does NOT exists", user);
	}
	
	//Editing the details
	@Test
	public void updateUser()
	{
		String username = "Abhi";
		User user = userDAO.getUserById(username);
		if(user != null)
		{
			user.setCustName("Testing");
			userDAO.updateUser(user);
			assertTrue("Problem in updating user",userDAO.updateUser(user));
		}
	}
	
	//Delete the record
	@Test
	public void deleteUser()
	{
		String username = "Abhi";
		User user = userDAO.getUserById(username);
		if(user != null)
		{
			userDAO.deleteUser(user);
			assertTrue("Problem in deleting user",userDAO.deleteUser(user));
		}
	}
}
