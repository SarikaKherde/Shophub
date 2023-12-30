package com.example.exceptionhandling;

public class WishlistNotFoundException extends Exception  {
	public WishlistNotFoundException(String message)
	{
		super(message);
	}
}
