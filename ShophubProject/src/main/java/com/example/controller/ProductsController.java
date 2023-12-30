package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Products;
import com.example.exceptionhandling.CategoryNotFoundException;
import com.example.exceptionhandling.ProductNotFoundException;
import com.example.service.ProductsService;
import com.example.service.Impl.ProductsServiceImpl;

import jakarta.validation.Valid;

@RestController
public class ProductsController {
	//To Inject Bean of Class
	@Autowired
	ProductsServiceImpl productsServiceImpl;
	
	@Autowired
	ProductsService productService;
	
	//To add Products
	@PostMapping("/products")
	public ResponseEntity<Object> addNewProducts(@Valid @RequestBody Products p )throws CategoryNotFoundException
	{
		Products p1 = productsServiceImpl.addNewProducts(p);
		return new ResponseEntity<>(p1,HttpStatus.OK);
	}
	
	//To get all Products
	@GetMapping("/products")
	public List<Products> findAllProducts()
	{
		return productsServiceImpl.getAllProducts();
	}
	
	//To get Products by name
	@GetMapping("/products/{productName}")
	public ResponseEntity<Object> getProductByName(@PathVariable String productName)
	{
		Products p = productService.getProductByName(productName);
		if(p != null)
		{
			return new ResponseEntity<Object>(p,HttpStatus.FOUND);
		}
		Map<String, String> map = new HashMap<>();
		map.put("errorMessage", "Product is not present");
		return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
	}
	
	//To update Products
	@PutMapping("/products")
	public ResponseEntity<Object> updateProduct(@RequestBody Products p)
	{
		Products updates = productService.updateProductByName(p); 
		if(updates != null)
		{
			return new ResponseEntity<Object>(p,HttpStatus.OK);
		}
		Map<String, String> map = new HashMap<>();
		map.put("errorMessage", "Product is not present");
		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	}
	
	//To get Products by name
	@GetMapping("/product/{id}")
	public Products FindProductById(@PathVariable int id)throws ProductNotFoundException
	{
		return productsServiceImpl.findProductsById(id);
	}
	
	//To delete Products
	@DeleteMapping("/products/{productName}")
	public ResponseEntity<Object> deleteProduct(@PathVariable String productName )
	{
		String check = productService.deleteProductByName(productName);
		if(check != null)
		{
			return new ResponseEntity<Object>("Product Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(check, HttpStatus.NOT_FOUND);
	}
	

}
