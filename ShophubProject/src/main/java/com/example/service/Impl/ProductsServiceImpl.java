package com.example.service.Impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Categories;
import com.example.entity.Products;
import com.example.exceptionhandling.CategoryNotFoundException;
import com.example.exceptionhandling.ProductNotFoundException;
import com.example.repository.CategoriesRepository;
import com.example.repository.ProductsRepository;
import com.example.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService 
{

	@Autowired
	ProductsRepository productsRepository;
	
	@Autowired
	CategoriesRepository categoriesRepository;
	
	@Override
	public Products addNewProducts(Products p) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		Optional<Categories> op2 = categoriesRepository.findById(p.getProductCategoryID());
		if(op2.isPresent())
		{
		Categories c1 =categoriesRepository.findById(p.getProductCategoryID()).get();
		p.setCategories(c1);
		return productsRepository.save(p);
	    }
		else
		{
			throw new CategoryNotFoundException("Category is not avilable on this id");
		}
	}
	
	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return productsRepository.findAll();
	}

	@Override
	public Products findProductsById(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Optional<Products> op1 = productsRepository.findById(id);
		if(op1.isPresent())
		{
			return productsRepository.findById(id).get();
		}
		else 
		{
		   throw new ProductNotFoundException("Product is not avilable on this id");
	    }
	}

	@Override
	public String deleteProductByName(String productName) {
		// TODO Auto-generated method stub
		Products p = productsRepository.getProductByProductName(productName);
		if(p == null) {
		return null;
	}
		productsRepository.deleteById(p.getProductID());
		return "Product deleted successfully";
}

	@Override
	public Products updateProductByName(Products p) {
		// TODO Auto-generated method stub
		Products existingProduct = productsRepository.getProductByProductName(p.getProductName());
		if(existingProduct == null) {
		return null;
	}

		existingProduct.setPrice(p.getPrice());
		existingProduct.setStockQuantity(p.getStockQuantity());
		existingProduct.setDescription(p.getDescription());
		existingProduct.setProductCategoryID(p.getProductCategoryID());
		
		return productsRepository.save(existingProduct);
	}

	@Override
	public Products getProductByName(String productName){
		// TODO Auto-generated method stub
		return productsRepository.getProductByProductName(productName);
	}
		


	

	
	
}
