package com.niit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.User;


@Transactional
@Repository("categoryDAO")

public class CategoryDAOImpl implements CategoryDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDAOImpl (SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	// Adding a category
	@Transactional
	@Override
	public boolean addCategory (Category c) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(c);
			System.out.println("Category added successfully!!!");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error in adding Category !!!");
			System.out.println(e);
			return false;
		}
	}
	
	// Updating a Category
	@Transactional
	@Override
	public boolean updateCategory (Category c) 
		{
			try
			{
				sessionFactory.getCurrentSession().update(c);
				System.out.println("Category updated successfully !!!");
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Error updating category !!!");	
				System.out.println(e);
				return false;
			}
		}
	
	// Deleting a specific Category by category name 
	@Transactional
	@Override
	public boolean deleteCategory (Category c) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(c);
			System.out.println("Category deleted Successfully !!!");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error in deleting Category !!!");	
			System.out.println(e);
			return false;
		}
	}
		
		// Getting entire category list
		@Override
		public List<Category> getCategories() 
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Category");
			List<Category> listCategories=query.list();
			System.out.println("Fetched all Categories successfully!!!");
			return listCategories;
		}
		
		//Get Category by specific Category Name
		@Override
		public Category getCategoryByName(String name)
		{
			Category c=null;
			try
			{
				Session session = sessionFactory.getCurrentSession();
				c = (Category)session.get(Category.class, name);
				System.out.println("Fetching the Category by Name is Successfull!!!");
				return (c);
			}
			catch(Exception e)
			{
				System.out.println("ERROR fetching the Category by Name !!!");
				System.out.println(e);
				return (c);
			}
		}
}