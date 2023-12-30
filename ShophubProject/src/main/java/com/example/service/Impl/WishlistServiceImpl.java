package com.example.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Products;
import com.example.entity.Wishlist;
import com.example.exceptionhandling.CategoryNotFoundException;
import com.example.exceptionhandling.WishlistNotFoundException;
import com.example.repository.WishlistRepository;
import com.example.service.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService {
	@Autowired
	WishlistRepository wishlistRepository;
	
	
	@Autowired
	ProductsServiceImpl productsServiceImpl;

	@Override
	public Wishlist addWishlist(Wishlist wishlist) {
		// TODO Auto-generated method stub
		return wishlistRepository.save(wishlist);
	}

	@Override
	public List<Wishlist> getAllWishlist() {
		// TODO Auto-generated method stub
		return wishlistRepository.findAll();
	}

	@Override
	public Wishlist getWishlistById(int id) throws WishlistNotFoundException {
		// TODO Auto-generated method stub
		 Optional<Wishlist> op1 =wishlistRepository.findById(id);
		 if(op1.isPresent())
		 {
		     return wishlistRepository.findById(id).get();
		 }
		 else 
			{
			   throw new WishlistNotFoundException("Wishlist is not avilable on this id");
		    }
	}

	@Override
	public String deleteWishlistById(int id) throws WishlistNotFoundException {
		// TODO Auto-generated method stub
		Optional<Wishlist> op2 =wishlistRepository.findById(id);
		if(op2.isPresent())
		{
			wishlistRepository.deleteById(id);
		     return "Wishlist deleted successfully";
	     }
		 else 
		{
			   throw new WishlistNotFoundException("Wishlist is not avilable on this id");
	    }
	}







}
