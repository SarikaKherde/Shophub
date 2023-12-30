package com.example.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Products;
import com.example.entity.Reviews;
import com.example.exceptionhandling.ProductNotFoundException;
import com.example.exceptionhandling.ReviewNotFoundException;
import com.example.repository.ProductsRepository;
import com.example.repository.ReviewsRepository;
import com.example.service.ReviewsService;
@Service
public class ReviewsServiceImpl implements ReviewsService {

	@Autowired
	ReviewsRepository reviewsRepository;
	
	@Autowired
	ProductsRepository productsRepository;
	

	@Override
	public List<Reviews> getAllReviews() {
		// TODO Auto-generated method stub
		return reviewsRepository.findAll();
	}

	@Override
	public Reviews findReviewsById(int id) throws ReviewNotFoundException {
		// TODO Auto-generated method stub
		Optional<Reviews> op2 = reviewsRepository.findById(id);
		if(op2.isPresent())
		{
			return reviewsRepository.findById(id).get();
		}
		else 
		{
		   throw new ReviewNotFoundException("Reviews is not avilable on this id");
	    }
	}

	@Override
	public String deleteReviewByReviewID(int id)throws ReviewNotFoundException {
		// TODO Auto-generated method stub
		Optional<Reviews> op3 = reviewsRepository.findById(id);
		if(op3.isPresent())
		{
			reviewsRepository.deleteById(id);
			return "Review deleted successfully";
		}
		else
		{
			throw new ReviewNotFoundException("Review is not avilable on this id");
		}
	}


	@Override
	public Reviews addNewReviews(Reviews reviews) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Optional<Products> op1 = productsRepository.findById(reviews.getReviewsProductID());
		if(op1.isPresent())
		{
		Products p1 =productsRepository.findById(reviews.getReviewsProductID()).get();
		reviews.setProducts(p1);
		return reviewsRepository.save(reviews);
	    }
		else
		{
			throw new ProductNotFoundException("Product is not avilable on this id");
		}
	}


}
