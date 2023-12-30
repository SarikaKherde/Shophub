package com.example.service;

import java.util.List;
import com.example.entity.Orders;
import com.example.exceptionhandling.OrderNotFoundException;


public interface OrdersService {
	public Orders addOrders(Orders orders);
	public void addProductToOrders(int orderID, int productID);
    public List<Orders> getAllOrders();
	public Orders getOrdersById(int id)throws OrderNotFoundException;
	public String deleteOrdersById(int id)throws OrderNotFoundException;

}
