package com.niit.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

public class SupplierTetsCase 
{

	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.niit");
		annotationConfigAppContext.refresh();
		supplierDAO=(SupplierDAO)annotationConfigAppContext.getBean("supplierDAO");
	}
	
	// Adding new supplier
	@Test
	public void addSupplier()
	{
		Supplier supplier =new Supplier();
		supplier.setSupplier_name("Ambattur Clothing");
		supplier.setSupplier_category("Casual Shirts");
		assertTrue("Problem in Adding Supplier",supplierDAO.addSupplier(supplier));
	}
	
	//Getting the details of entire supplier list
	@Test
	public void getAllSuppliers()
	{
		List<Supplier> listSuppliers=supplierDAO.getAllSuppliers();
		assertTrue("No Suppliers ",listSuppliers.size()>0);
		System.out.println("The total number of suppliers : "+listSuppliers.size());
	}
	
	// Getting the Supplier details by name
	@Test
	public void getSupplier()
	{
		String supplier_name = "Ambattur Clothing";
		Supplier supplier = supplierDAO.getSupplierByName(supplier_name);
		Assert.assertNotNull("Supplier does NOT exists", supplier);
	}
	
	//Updating the details
	@Test
	public void updateSupplier()
	{
		String sup_category = "Formal Shirts & Pants";
		Supplier supplier = supplierDAO.getSupplierByName("Arvind apparels");
		if(supplier != null)
		{
			supplier.setSupplier_category(sup_category);
			supplierDAO.updateSupplier(supplier);
			assertTrue("Problem in updating Category",supplierDAO.updateSupplier(supplier));
		}
	}
	
	
	//Delete the record
	@Test
	public void deleteSupplier()
	{
		String supplier_name = "Arvind apparels";
		Supplier supplier = supplierDAO.getSupplierByName(supplier_name);
		System.out.println("The supplier to be deleted is : "+supplier.getSupplier_name());
		if(supplier != null)
		{
			//supplierDAO.deleteSupplier(supplier);
			assertTrue("Problem in deleting user",supplierDAO.deleteSupplier(supplier));
		}
	}
	
		
}
