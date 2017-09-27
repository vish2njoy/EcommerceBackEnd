package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDAO 
{
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public List<Supplier> getAllSuppliers();
	public Supplier getSupplierByName(String supplier_name);
	public boolean deleteSupplier(Supplier supplier);
		
}
