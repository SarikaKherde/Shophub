package com.example.exceptionhandling;

public class ShoppingCartNotFoundException extends Exception {

	public ShoppingCartNotFoundException(String message)
	{
		super(message);
	}
}
