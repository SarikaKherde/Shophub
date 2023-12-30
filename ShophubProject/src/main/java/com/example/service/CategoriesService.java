package com.example.service;

import java.util.List;

import com.example.entity.Categories;
import com.example.exceptionhandling.CategoryNotFoundException;

public interface CategoriesService {

	public Categories addCategory(Categories c);
	
	public List<Categories> getAllCategories();
	
	public Categories getCategoryById(int id)throws CategoryNotFoundException;
	
	public String deleteCategoriesByName(String categoryName);
	
	public Categories updateCategoriesByName(Categories c);
	
	public Categories getCategoryByCategoryName(String categoryName);
	
}
