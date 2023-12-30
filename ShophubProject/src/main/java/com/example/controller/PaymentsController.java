package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Payments;
import com.example.exceptionhandling.PaymentNotFoundException;
import com.example.service.Impl.PaymentsServiceImpl;

import jakarta.validation.Valid;

@RestController
public class PaymentsController {
	//To Inject Bean of Class
	@Autowired
	PaymentsServiceImpl paymentsServiceImpl;
	
	//To add payments
	@PostMapping("/payments")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public ResponseEntity<Object> addPayments(@Valid @RequestBody Payments payments)
	{
		Payments payments1 =paymentsServiceImpl.addPayments(payments);
		return new ResponseEntity<>(payments1, HttpStatus.OK);
	}
	
	//To get payments
	@GetMapping("/payments")
	public List<Payments> findAllPayments()
	{
		return paymentsServiceImpl.getAllPayments();
	}
	
	//To get payments by id
	@GetMapping("/payments/{id}")
	public Payments findPaymentsById(@PathVariable int id)throws PaymentNotFoundException {
		return paymentsServiceImpl.getPaymentsById(id);
	}
	
	//To delete payments
	@DeleteMapping("/payments/{id}")
	public ResponseEntity<Object> deletePayments(@PathVariable int id)throws PaymentNotFoundException
	{
		String check = paymentsServiceImpl.deletePaymentById(id);
		if(check != null)
		{
			return new ResponseEntity<Object>("Payments Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(check, HttpStatus.NOT_FOUND);
	}
	
}
