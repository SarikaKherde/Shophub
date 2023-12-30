package com.example.exceptionhandling;

public class CategoryNotFoundException extends Exception {

	public CategoryNotFoundException(String message)
	{
		super(message);
	}
}
