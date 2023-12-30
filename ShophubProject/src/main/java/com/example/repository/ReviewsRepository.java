package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Products;
import com.example.entity.Reviews;
import com.example.entity.User;


public interface ReviewsRepository extends JpaRepository<Reviews, Integer>{
	 Optional<Reviews> findByUserAndProducts(User user, Products products);
}
