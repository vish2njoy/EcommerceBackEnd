package com.niit.test;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import javax.naming.Context;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.model.User;
import com.niit.dao.UserDAO;

import com.niit.model.Category;
import com.niit.dao.CategoryDAO;

import com.niit.model.Product;
import com.niit.dao.ProductDAO;

import com.niit.model.Supplier;
import com.niit.dao.SupplierDAO;

import com.niit.model.Cart;
import com.niit.dao.CartDAO;

public class CartTestCase 
{
	static CartDAO cartDAO;
	@Autowired
	static UserDAO userDAO;
	@Autowired
	static ProductDAO productDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit");
		annotationConfigAppContext.refresh();
		
		cartDAO=(CartDAO)annotationConfigAppContext.getBean("cartDAO");
		System.out.println("CartDAO initiated");
		
		productDAO=(ProductDAO)annotationConfigAppContext.getBean("productDAO");
		System.out.println("ProductDAO initiated");
		
		userDAO=(UserDAO) annotationConfigAppContext.getBean("userDAO");
		System.out.println("UserDAO initiated");
	}
	
	// Adding new Cart Record
	@Test
	public void saveCategory()
	{
		Product p =  new Product();
		User user = new User();
		
		p = productDAO.getProductByName("Checked Shirts");
		user=userDAO.getUserById("Test1");
		int quantity = 2;
		int price;
		if(p!=null && user!=null)
		{
			// Adding into Cart!
			Cart cart =new Cart();
			cart.setUser(user);;
			cart.setProduct(p);
			cart.setQuantity(quantity);
			price = Integer.parseInt(p.getPrice());
			System.out.println("The price of the selected product is "+price);
			price = price * quantity;
			System.out.println("The total value is "+price);
			cart.setPrice(price);
			assertTrue("Problem in Adding Product",cartDAO.saveCart(cart));
		}
		else
		{
			System.out.println("Category Not Available");
		}
	}
	
	//Get Cart by User Name
	@Test
	public void getCartListByName()
	{
		String user = "Test";
		List<Cart> cartList =cartDAO.getCartByUser(user);
		assertTrue("No cart items for the selected user ",cartList.size()>0);
	}
	
	//Get Cart details by Cart ID
	@Test
	public void getCartByID()
	{
		int id = 1;
		Cart cart = cartDAO.getCartByID(id);
		Assert.assertNotNull("Cart for the id " +id + " does NOT exists", cart);
	}
	
	//Delete Cart by ID
	@Test
	public void deleteCart()
	{
		int id = 2;
		Cart cart = cartDAO.getCartByID(id);
		if(cart != null)
		{
			assertTrue("Problem in deleting Cart details ",cartDAO.deleteCart(cart));
			System.out.println("Hi");
			
		}
		else
		{
			System.out.println("Cart does not exists for the chosen ID  : " +id);
		}
	}

}