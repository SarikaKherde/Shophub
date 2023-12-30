package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
	public Categories getCategoryByCategoryName(String categoryName);

}
