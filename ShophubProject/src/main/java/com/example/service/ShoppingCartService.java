package com.example.service;

import java.util.List;

import com.example.entity.Products;
import com.example.entity.ShoppingCart;
import com.example.exceptionhandling.CategoryNotFoundException;
import com.example.exceptionhandling.ShoppingCartNotFoundException;

public interface ShoppingCartService {

	public ShoppingCart addShoppingCart(ShoppingCart shoppingCart);
    public List<ShoppingCart> getAllShoppingCart();
	public ShoppingCart getShoppingCartById(int id)throws ShoppingCartNotFoundException;
	public String deleteShoppingCartById(int id)throws ShoppingCartNotFoundException;
	public void addToCart(int userID,int productID,int quantity);
}
