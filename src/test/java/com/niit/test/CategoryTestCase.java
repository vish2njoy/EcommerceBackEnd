package com.niit.test;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Category;
import com.niit.model.User;

public class CategoryTestCase 
{

	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit");
		annotationConfigAppContext.refresh();
		categoryDAO=(CategoryDAO)annotationConfigAppContext.getBean("categoryDAO");
	}
	
	// Adding new Category
	@Test
	public void addCategory()
	{
		Category c =new Category();
		c.setName("Womens Wear");
		c.setDescription("Woens Mens Wear Dresses");
		c.setSubcategory("Casuals");
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(c));
	}
	
	//Updating the details
	@Test
	public void updateCategory()
	{
		String description = "Womens Wear Dresses for all ages";
		Category c = categoryDAO.getCategoryByName("Womens Wear");
		if(c != null)
		{
			c.setDescription(description);
			categoryDAO.updateCategory(c);
			assertTrue("Problem in updating Category",categoryDAO.updateCategory(c));
		}
	}
	
	//Delete the category
	@Test
	public void deleteCategory()
	{
			String name = "Womens Wear";
			Category cat = categoryDAO.getCategoryByName(name);
			System.out.println(cat.getDescription());
			if(cat != null)
			{
				assertTrue("Problem in deleting category",categoryDAO.deleteCategory(cat));
			}
			else
			{
				System.out.println("The Category does not exists : " +name);
			}
		}
	//Getting the Category list
	@Test
	public void getCategories()
	{
		List<Category> listCategories=categoryDAO.getCategories();
		assertTrue("No Users",listCategories.size()>0);
	}
	
	//Get Category by Name
	@Test
	public void getCategoryByName()
	{
		String name = "Womens Wear";
		Category c = categoryDAO.getCategoryByName(name);
		Assert.assertNotNull("Category does NOT exists", c);
	}
}
