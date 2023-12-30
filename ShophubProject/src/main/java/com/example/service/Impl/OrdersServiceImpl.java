package com.example.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Orders;
import com.example.entity.Products;
import com.example.exceptionhandling.OrderNotFoundException;
import com.example.exceptionhandling.ResourceNotFoundException;
import com.example.repository.OrdersRepository;
import com.example.repository.ProductsRepository;
import com.example.service.OrdersService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	ProductsRepository productsRepository;
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Override
	public Orders addOrders(Orders orders) {
		// TODO Auto-generated method stub
		return ordersRepository.save(orders);
	}
	
	@Override
	public void addProductToOrders(int orderID, int productID) {
		// TODO Auto-generated method stub
		try {
		Orders orders = ordersRepository.findById(orderID).orElseThrow(() -> new EntityNotFoundException("Orders not found"));
		Products products =productsRepository.findById(productID).orElseThrow(() -> new EntityNotFoundException("Product not found"));
		
		orders.getProducts().add(products);
		products.getOrders().add(orders);

		ordersRepository.save(orders);
        productsRepository.save(products);
	
		}catch(Exception e) 
		{
		  throw new ResourceNotFoundException(e.getMessage());
        }	
	}


	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return ordersRepository.findAll();
	}

	@Override
	public Orders getOrdersById(int id) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		 Optional<Orders> op1 =ordersRepository.findById(id);
		 if(op1.isPresent())
		 {
		     return ordersRepository.findById(id).get();
		 }
		 else 
			{
			   throw new OrderNotFoundException("Orders is not avilable on this id");
		    }
	}

	@Override
	public String deleteOrdersById(int id) throws OrderNotFoundException {
		// TODO Auto-generated method stub
		Optional<Orders> op2 =ordersRepository.findById(id);
		if(op2.isPresent())
		{
			ordersRepository.deleteById(id);
		     return "Orders deleted successfully";
	     }
		 else 
		{
			   throw new OrderNotFoundException("Orders is not avilable on this id");
	    }
	}








	

}
