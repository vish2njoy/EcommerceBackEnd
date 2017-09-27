package com.niit.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="product_name")
	private Product product;
	private int quantity;
	private int price;
	
	// Getters and Setters methods
	public User getUser() 
	{
		return user;
	}
	public void setUser(User user) 
	{
		this.user = user;
	}
	public Product getProduct()
	{
		return product;
	}
	public void setProduct(Product product)
	{
		this.product = product;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}	
}