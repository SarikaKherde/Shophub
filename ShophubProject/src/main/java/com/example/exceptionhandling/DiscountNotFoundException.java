package com.example.exceptionhandling;

public class DiscountNotFoundException extends Exception {

	public DiscountNotFoundException(String message)
	{
		super(message);
	}
}
