package com.example.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Categories;
import com.example.exceptionhandling.CategoryNotFoundException;
import com.example.repository.CategoriesRepository;
import com.example.service.CategoriesService;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	CategoriesRepository categoriesRepository;
	
	@Override
	public Categories addCategory(Categories c) {
		// TODO Auto-generated method stub
		return categoriesRepository.save(c);
	}

	@Override
	public List<Categories> getAllCategories() {
		// TODO Auto-generated method stub
		return categoriesRepository.findAll();
	}

	
	@Override
	public Categories getCategoryById(int id) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
	 Optional<Categories> op1 = categoriesRepository.findById(id);
		if(op1.isPresent())
		{
		return categoriesRepository.findById(id).get();
	}
	else 
	{
	   throw new CategoryNotFoundException("Category is not avilable on this id");
    }
	}


	@Override
	public Categories getCategoryByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return categoriesRepository.getCategoryByCategoryName(categoryName);
	}

	@Override
	public Categories updateCategoriesByName(Categories c) {
		// TODO Auto-generated method stub
		Categories existingCategories = categoriesRepository.getCategoryByCategoryName(c.getCategoryName());
		if(existingCategories == null) {
		return null;
	}

		existingCategories.setDescription(c.getDescription());
		existingCategories.setImageUrl(c.getImageUrl());

		return categoriesRepository.save(existingCategories);
	}

	@Override
	public String deleteCategoriesByName(String categoryName) {
		// TODO Auto-generated method stub
		Categories c = categoriesRepository.getCategoryByCategoryName(categoryName);
		if(c == null) {
		return null;
	}
		categoriesRepository.deleteById(c.getCategoryID());
		return "Category deleted successfully";
	}

	


}
