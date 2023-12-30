package com.example.service;

import java.util.List;


import com.example.entity.Products;
import com.example.exceptionhandling.CategoryNotFoundException;
import com.example.exceptionhandling.ProductNotFoundException;


public interface ProductsService {

	 public Products addNewProducts(Products p)throws CategoryNotFoundException;
	 
	 public List<Products> getAllProducts();
	 
	 public Products findProductsById(int id)throws ProductNotFoundException;
	 
	public String deleteProductByName(String productName);
	
	public Products updateProductByName(Products p);
	
	public Products getProductByName(String productName);
}
