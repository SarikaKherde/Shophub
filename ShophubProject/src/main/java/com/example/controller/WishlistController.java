package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Products;
import com.example.entity.Wishlist;
import com.example.exceptionhandling.CategoryNotFoundException;
import com.example.exceptionhandling.WishlistNotFoundException;
import com.example.service.Impl.WishlistServiceImpl;

import jakarta.validation.Valid;

@RestController
public class WishlistController {
	//To Inject Bean of Class
	@Autowired
	WishlistServiceImpl wishlistServiceImpl;
	
	//To add wishList
	@PostMapping("/wishlist")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public ResponseEntity<Object> addWishlist(@Valid @RequestBody Wishlist wishlist)
	{
		Wishlist wishlist1 =wishlistServiceImpl.addWishlist(wishlist);
		return new ResponseEntity<>(wishlist1, HttpStatus.OK);
	}
	
	//To get wishList
	@GetMapping("/wishlist")
	public List<Wishlist> findAllWishlist()
	{
		return wishlistServiceImpl.getAllWishlist();
	}
	
	//To get wishList by id
	@GetMapping("/wishlists/{id}")
	public Wishlist findWishlistById(@PathVariable int id)throws WishlistNotFoundException {
		return wishlistServiceImpl.getWishlistById(id);
	}
	
	//To delete wishList by id
	@DeleteMapping("/wishlist/{id}")
	public ResponseEntity<Object> deleteWishlist(@PathVariable int id)throws WishlistNotFoundException
	{
		String check = wishlistServiceImpl.deleteWishlistById(id);
		if(check != null)
		{
			return new ResponseEntity<Object>("Wishlist Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(check, HttpStatus.NOT_FOUND);
	}


}
