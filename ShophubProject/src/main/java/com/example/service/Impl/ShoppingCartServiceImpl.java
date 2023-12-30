package com.example.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CartItem;
import com.example.entity.Products;
import com.example.entity.ShoppingCart;
import com.example.entity.User;
import com.example.exceptionhandling.ShoppingCartNotFoundException;
import com.example.repository.CartItemRepository;
import com.example.repository.ProductsRepository;
import com.example.repository.ShoppingCartRepository;
import com.example.repository.UserRepository;
import com.example.service.ShoppingCartService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductsRepository productsRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Override
	public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return shoppingCartRepository.save(shoppingCart);
	}

	@Override
	public List<ShoppingCart> getAllShoppingCart() {
		// TODO Auto-generated method stub
		return shoppingCartRepository.findAll();
	}

	@Override
	public ShoppingCart getShoppingCartById(int id) throws ShoppingCartNotFoundException {
		// TODO Auto-generated method stub
		 Optional<ShoppingCart> op1 =shoppingCartRepository.findById(id);
		 if(op1.isPresent())
		 {
		     return shoppingCartRepository.findById(id).get();
		 }
		 else 
			{
			   throw new ShoppingCartNotFoundException("ShoppingCart is not avilable on this id");
		    }
	}

	@Override
	public String deleteShoppingCartById(int id) throws ShoppingCartNotFoundException {
		// TODO Auto-generated method stub
		Optional<ShoppingCart> op2 =shoppingCartRepository.findById(id);
		if(op2.isPresent())
		{
		     shoppingCartRepository.deleteById(id);
		     return "ShoppingCart deleted successfully";
	     }
		 else 
		{
			   throw new ShoppingCartNotFoundException("ShoppingCart is not avilable on this id");
	    }
	}

	@Override
	public void addToCart(int userID, int productID, int quantity) {
		// TODO Auto-generated method stub
		   User user = userRepository.findById(userID).orElseThrow(() -> new EntityNotFoundException("User not found"));

	        Products products = productsRepository.findById(productID).orElseThrow(() -> new EntityNotFoundException("Product not found"));

	        ShoppingCart shoppingCart = user.getShoppingCart();
	        if (shoppingCart == null) {
	            shoppingCart = new ShoppingCart();
	            shoppingCart.setUser(user);;
	            user.setShoppingCart(shoppingCart);
	        }

	        CartItem cartItem = new CartItem();
	        cartItem.setShoppingCart(shoppingCart);
	        cartItem.setProducts(products);
	        cartItem.setQuantity(quantity);

	        shoppingCart.getCartItems().add(cartItem);

	        shoppingCartRepository.save(shoppingCart);
	    }
	}
	


