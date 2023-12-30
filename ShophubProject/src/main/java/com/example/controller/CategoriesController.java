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

import com.example.entity.Categories;
import com.example.exceptionhandling.CategoryNotFoundException;
import com.example.service.Impl.CategoriesServiceImpl;
import jakarta.validation.Valid;


@RestController
public class CategoriesController {
	

	//To Inject Bean of Class
	@Autowired
	CategoriesServiceImpl categoriesServiceImpl;
	
	//To add Category
	@PostMapping("/categories")
	public ResponseEntity<Object> addCategories(@Valid @RequestBody Categories c)
	{
		Categories c1 =categoriesServiceImpl.addCategory(c);
		return new ResponseEntity<>(c1, HttpStatus.OK);
	}
	
	
	//To get all Category
	@GetMapping("/categories")
	public List<Categories> findAllCategories()
	{
		return categoriesServiceImpl.getAllCategories();
	}
	
	
	//To get Category by name
	@GetMapping("/categories/{categoryName}")
	public ResponseEntity<Object> getCategoryByName(@PathVariable String categoryName)
	{
		Categories c = categoriesServiceImpl.getCategoryByCategoryName(categoryName);
		if(c != null)
		{
			return new ResponseEntity<Object>(c,HttpStatus.FOUND);
		}
		Map<String, String> map = new HashMap<>();
		map.put("errorMessage", "Category is not present");
		return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
	}
	
	
	//To update Category
	@PutMapping("/categories")
	public ResponseEntity<Object> updateCategory(@RequestBody Categories c)
	{
		Categories updates = categoriesServiceImpl.updateCategoriesByName(c); 
		if(updates != null)
		{
			return new ResponseEntity<Object>(c,HttpStatus.OK);
		}
		Map<String, String> map = new HashMap<>();
		map.put("errorMessage", "Category is not present");
		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	}
	
	//To get Category by id
	@GetMapping("/category/{id}")
	public Categories findCategoryById(@PathVariable int id)throws CategoryNotFoundException {
		return categoriesServiceImpl.getCategoryById(id);
	}
	
	//To delete Category
	@DeleteMapping("/categories/{categoryName}")
	public ResponseEntity<Object> deleteCategory(@PathVariable String categoryName )
	{
		String check =categoriesServiceImpl.deleteCategoriesByName(categoryName);
		if(check != null)
		{
			return new ResponseEntity<Object>("Category Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(check, HttpStatus.NOT_FOUND);
	}
}
