package com.example.service;

import java.util.List;
import com.example.entity.Reviews;
import com.example.exceptionhandling.ProductNotFoundException;
import com.example.exceptionhandling.ReviewNotFoundException;

public interface ReviewsService {
	
	 public Reviews addNewReviews(Reviews reviews)throws ProductNotFoundException;
	 
	 public List<Reviews> getAllReviews();
	 
	 public Reviews findReviewsById(int id)throws ReviewNotFoundException;
	 
	public String deleteReviewByReviewID(int id)throws ReviewNotFoundException;


}
