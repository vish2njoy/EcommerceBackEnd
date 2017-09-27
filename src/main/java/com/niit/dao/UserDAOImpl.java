package com.niit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;


@Transactional
@Repository("userDAO")

public class UserDAOImpl implements UserDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	// Adding a User
	@Transactional
	@Override
	public boolean addUser (User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			System.out.println("User added successfully!!!");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error in adding User !!!");
			System.out.println(e);
			return false;
		}
	}

	// Getting users created
	@Override
	public List<User> getAllUsers() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listUsers=query.list();
		System.out.println("Fetched all users successfully!!!");
		return listUsers;
	}

	// Getting user by ID
	@Override
		public User getUserById(String username)
		{
			User user=null;
			try
			{
				Session session = sessionFactory.getCurrentSession();
				user = (User)session.get(User.class, username);
				System.out.println("Fetching the user by User Name success!!!");
				return (user);
			}
			catch(Exception e)
			{
				System.out.println("Error fetching the user by User Name !!!");
				System.out.println(e);
				return (user);
			}
		}
		
	// Updating Records
	@Transactional
	@Override
	public boolean updateUser (User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			System.out.println("User details updated successfully !!!");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error updating the user details !!!");	
			System.out.println(e);
			return false;
		}
	}
		
	// Deleting a User record
	@Transactional
	@Override
	public boolean deleteUser (User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			System.out.println("User deleted Successfully !!!");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error in deleting user !!!");	
			System.out.println(e);
			return false;
		}
	}
}
