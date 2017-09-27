package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier 
{
	@Id
	private String supplier_name;
	private String supplier_category;
	
	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getSupplier_category() {
		return supplier_category;
	}

	public void setSupplier_category(String supplier_category) {
		this.supplier_category = supplier_category;
	}
	
}
