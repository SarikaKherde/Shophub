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

import com.example.entity.Products;
import com.example.entity.ShoppingCart;
import com.example.exceptionhandling.CategoryNotFoundException;
import com.example.exceptionhandling.ShoppingCartNotFoundException;
import com.example.service.Impl.ShoppingCartServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
public class ShoppingCartController {
	//To Inject Bean of Class
	@Autowired
	ShoppingCartServiceImpl shoppingCartServiceImpl;
	
	//To add shoppingCart
	@PostMapping("/shoppingCart")
	public ResponseEntity<Object> addShoppingCart(@Valid @RequestBody ShoppingCart shoppingCart)
	{
		ShoppingCart shoppingCart1 =shoppingCartServiceImpl.addShoppingCart(shoppingCart);
		return new ResponseEntity<>(shoppingCart1, HttpStatus.OK);
	}
	
	//To get shoppingCart
	@GetMapping("/shoppingCart")
	public List<ShoppingCart> findAllShoppingCart()
	{
		return shoppingCartServiceImpl.getAllShoppingCart();
	}
	
	//To get shoppingCart by id
	@GetMapping("/shoppingCart/{id}")
	public ShoppingCart findShoppingCartById(@PathVariable int id)throws ShoppingCartNotFoundException {
		return shoppingCartServiceImpl.getShoppingCartById(id);
	}
	
	//To delete shoppingCart
	@DeleteMapping("/shoppingCart/{id}")
	public ResponseEntity<Object> deleteShoppingCart(@PathVariable int id)throws ShoppingCartNotFoundException
	{
		String check = shoppingCartServiceImpl.deleteShoppingCartById(id);
		if(check != null)
		{
			return new ResponseEntity<Object>("ShoppingCart Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(check, HttpStatus.NOT_FOUND);
	}
	
	//To add product in shoppingCart 
	@PostMapping("/addToCart/{userID}/{productID}/{quantity}")
	public  ResponseEntity<String> addToCart(@PathVariable int userID,@PathVariable int productID,@PathVariable int quantity)
	{

        try {
        	shoppingCartServiceImpl.addToCart(userID, productID, quantity);
            return ResponseEntity.ok("Product added to the cart successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
	
}
