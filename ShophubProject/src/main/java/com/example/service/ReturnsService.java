package com.example.service;

import java.util.List;

import com.example.entity.Returns;
import com.example.exceptionhandling.ReturnNotFoundException;


public interface ReturnsService {

	public Returns addReturns(Returns returns);
    public List<Returns> getAllReturns();
	public Returns getReturnsById(int id)throws ReturnNotFoundException;
	public String deleteReturnsById(int id)throws ReturnNotFoundException;
}
