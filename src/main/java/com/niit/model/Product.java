package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Product implements Serializable
{
	@Id
	private String product_name;
	private String price;
	private String brand;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="category_name")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplier_name")
	private Supplier supplier;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getproduct_name() {
		return product_name;
	}
	public void setproductproduct_name(String product_name) {
		this.product_name= product_name;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
}