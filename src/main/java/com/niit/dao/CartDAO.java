package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDAO 
{
	public boolean saveCart(Cart cart);
	public Cart getCartByID(int id);
	public boolean deleteCart(Cart cart);
	public List<Cart> getCartByUser(String user);
	
}
