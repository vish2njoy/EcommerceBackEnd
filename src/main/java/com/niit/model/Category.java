package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category implements Serializable
{
	@Id
	private String name;
	
	private String description;
	private String subcategory;
	
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}