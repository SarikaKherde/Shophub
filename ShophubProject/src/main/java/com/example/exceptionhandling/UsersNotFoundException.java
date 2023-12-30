package com.example.exceptionhandling;

public class UsersNotFoundException extends Exception {

	public UsersNotFoundException(String message)
	{
		super(message);
	}
}
