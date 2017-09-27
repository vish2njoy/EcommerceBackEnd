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
import com.niit.model.Cart;


@Transactional
@Repository("cartDAO")

public class CartDAOImpl implements CartDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAOImpl (SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	// Adding a Product
	@Transactional
	@Override
	public boolean saveCart (Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			System.out.println("Cart added successfully!!!");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error in adding Product !!!");
			System.out.println(e);
			return false;
		}
	}
	
	// Getting the Cart Details by User.
	@Transactional
	@Override
	public List<Cart> getCartByUser(String user) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where user = '"+user+ "'");
		List<Cart> listCart=query.list();
		System.out.println("Fetched the list successfully!!!");
		System.out.println("The total number of items for the user - "+user+ " is : "+listCart.size());
		return listCart;
	}
	
	//Get Cart by Id
	
	@Override
	public Cart getCartByID(int id)
	{
		Cart cart=null;
		try
		{
			Session session = sessionFactory.getCurrentSession();
			cart = (Cart)session.get(Cart.class, id);
			System.out.println("Fetching the Cart details by ID success!!!");
			return (cart);
		}
		catch(Exception e)
		{
			System.out.println("Error fetching the Cart details by ID !!!");
			System.out.println(e);
			return (cart);
		}
	}
		
	// Deleting a Cart record
	@Transactional
	@Override
	public boolean deleteCart (Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
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