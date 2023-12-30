package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Reviews;
import com.example.exceptionhandling.ProductNotFoundException;
import com.example.exceptionhandling.ReviewNotFoundException;
import com.example.service.Impl.ProductsServiceImpl;
import com.example.service.Impl.ReviewsServiceImpl;

import jakarta.validation.Valid;

@RestController
public class ReviewsController {
	//To Inject Bean of Class
	@Autowired
	ReviewsServiceImpl reviewsServiceImpl;
	
	@Autowired
	ProductsServiceImpl productsServiceImpl;
	
	//To add reviews
	@PostMapping("/reviews")
	public ResponseEntity<Object> addNewReviews(@Valid @RequestBody Reviews reviews )throws ProductNotFoundException
	{
		Reviews reviews1 = reviewsServiceImpl.addNewReviews(reviews);
		return new ResponseEntity<>(reviews1,HttpStatus.OK);
	}
	
	//To get reviews
	@GetMapping("/reviews")
	public List<Reviews> findAllReviews()
	{
		return reviewsServiceImpl.getAllReviews();
	}

	//To get reviews by id
	@GetMapping("/review/{id}")
	public Reviews FindReviewsById(@PathVariable int id)throws ReviewNotFoundException
	{
		return reviewsServiceImpl.findReviewsById(id);
	}
	
	//To delete reviews by id
	@DeleteMapping("/reviews/{id}")
	public ResponseEntity<Object> deleteReviews(@PathVariable int id)throws ReviewNotFoundException
	{
		String check = reviewsServiceImpl.deleteReviewByReviewID(id);
		if(check != null)
		{
			return new ResponseEntity<Object>("Reviews Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(check, HttpStatus.NOT_FOUND);
	}
}
