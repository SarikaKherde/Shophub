package com.example.exceptionhandling;

public class ShipmentNotFoundException extends Exception {
	public ShipmentNotFoundException(String message)
	{
		super(message);
	}

}
