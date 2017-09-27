package com.niit.dao;

import java.util.List;
import com.niit.model.Category;

public interface CategoryDAO 
{
	public boolean addCategory(Category c);
	public boolean updateCategory(Category c);
	public boolean deleteCategory(Category c);
	public List<Category> getCategories();
	public Category getCategoryByName(String name);
	
}
