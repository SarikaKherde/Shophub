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
import com.example.entity.Orders;
import com.example.exceptionhandling.OrderNotFoundException;
import com.example.exceptionhandling.ResourceNotFoundException;
import com.example.service.Impl.OrdersServiceImpl;

import jakarta.validation.Valid;

@RestController
public class OrdersController {
	//To Inject Bean of Class
	@Autowired
	OrdersServiceImpl ordersServiceImpl;
	
	//To add orders
	@PostMapping("/orders")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public ResponseEntity<Object> addOrders(@Valid @RequestBody Orders orders)
	{
		Orders orders1 =ordersServiceImpl.addOrders(orders);
		return new ResponseEntity<>(orders1, HttpStatus.OK);
	}
	
	//To add orders by customer
	@PostMapping("/order/{productId}/{orderId}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public ResponseEntity<String> addProductToOrders(@PathVariable int orderId, @PathVariable int productId) {
	try {
	  ordersServiceImpl.addProductToOrders(orderId, productId);
	  return new ResponseEntity<>("Product Added to Order Scuccessfully",HttpStatus.OK);
	} 
	catch(ResourceNotFoundException e)
	{
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	}
	
	//To get orders
	@GetMapping("/orders")
	public List<Orders> findAllOrders()
	{
		return ordersServiceImpl.getAllOrders();
	}
	
	//To get orders by id
	@GetMapping("/order/{id}")
	public Orders findOrdersById(@PathVariable int id)throws OrderNotFoundException {
		return ordersServiceImpl.getOrdersById(id);
	}
	
	//To delete orders
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Object> deleteOrders(@PathVariable int id)throws OrderNotFoundException
	{
		String check = ordersServiceImpl.deleteOrdersById(id);
		if(check != null)
		{
			return new ResponseEntity<Object>("Orders Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(check, HttpStatus.NOT_FOUND);
	}

}
