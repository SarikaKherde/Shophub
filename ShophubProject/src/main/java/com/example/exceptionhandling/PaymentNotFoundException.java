package com.example.exceptionhandling;

public class PaymentNotFoundException extends Exception{

	public PaymentNotFoundException(String message)
	{
		super(message);
	}
}
