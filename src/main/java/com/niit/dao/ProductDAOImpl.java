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
import com.niit.model.Product;


@Transactional
@Repository("productDAO")

public class ProductDAOImpl implements ProductDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDAOImpl (SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	// Adding a Product
	@Transactional
	@Override
	public boolean addProduct (Product p) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(p);
			System.out.println("Product added successfully!!!");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error in adding Product !!!");
			System.out.println(e);
			return false;
		}
	}
	
	// Getting the Product Details by Category.
	@Transactional
	@Override
	public List<Product> getProductsByCategory(String category) 
	{
		Session session=sessionFactory.openSession();
		System.out.println(category);
		Query query=session.createQuery("from Product where category_name = '"+category + "'");
		List<Product> listProducts=query.list();
		System.out.println("Fetched all products successfully!!!");
		return listProducts;
	}
	
	//Getting the Product Details by Name
	@Override
	public Product getProductByName(String name)
	{
		Product p=null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			p = (Product)session.get(Product.class, name);
			System.out.println("Fetching the product by NAME success!!!");
			return (p);
		}
		catch(Exception e)
		{
			System.out.println("Error fetching the product by NAME !!!");
			System.out.println(e);
			return (p);
		}
	}
	
	//Get list of all the products
	@Override
	public List<Product> getProducts() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProducts=query.list();
		System.out.println("Fetched all Products successfully!!!");
		return listProducts;
	}
	
	// Updating Product records
	@Transactional
	@Override
	public boolean updateProduct (Product p) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(p);
			System.out.println("Record updated successfully !!!");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error updating the record !!!");	
			System.out.println(e);
			return false;
		}
	}
	
	// Deleting a Product record
	@Transactional
	@Override
	public boolean deleteProduct (Product p) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(p);
			System.out.println("Record deleted Successfully !!!");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error in deleting Records !!!");	
			System.out.println(e);
			return false;
		}
	}
}