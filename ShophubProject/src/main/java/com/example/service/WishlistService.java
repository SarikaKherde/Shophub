package com.example.service;

import java.util.List;

import com.example.entity.Products;
import com.example.entity.Wishlist;
import com.example.exceptionhandling.CategoryNotFoundException;
import com.example.exceptionhandling.WishlistNotFoundException;

public interface WishlistService {
	public Wishlist addWishlist(Wishlist wishlist);
    public List<Wishlist> getAllWishlist();
	public Wishlist getWishlistById(int id)throws WishlistNotFoundException;
	public String deleteWishlistById(int id)throws WishlistNotFoundException;
	

}
