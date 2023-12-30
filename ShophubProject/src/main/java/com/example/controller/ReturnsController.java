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

import com.example.entity.Returns;
import com.example.exceptionhandling.ReturnNotFoundException;
import com.example.service.Impl.ReturnsServiceImpl;

import jakarta.validation.Valid;
@RestController
public class ReturnsController {
	//To Inject Bean of Class
	@Autowired
	ReturnsServiceImpl returnsServiceImpl;
	
	//To add returns
	@PostMapping("/returns")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public ResponseEntity<Object> addReturns(@Valid @RequestBody Returns returns)
	{
		Returns returns1 =returnsServiceImpl.addReturns(returns);
		return new ResponseEntity<>(returns1, HttpStatus.OK);
	}
	
	//To get returns
	@GetMapping("/returns")
	public List<Returns> findAllReturns()
	{
		return returnsServiceImpl.getAllReturns();
	}
	
	//To get returns by is
	@GetMapping("/returns/{id}")
	public Returns findReturnsById(@PathVariable int id)throws ReturnNotFoundException {
		return returnsServiceImpl.getReturnsById(id);
	}
	
	//To delete returns by id
	@DeleteMapping("returns/{id}")
	public ResponseEntity<Object> deleteReturns(@PathVariable int id)throws ReturnNotFoundException
	{
		String check = returnsServiceImpl.deleteReturnsById(id);
		if(check != null)
		{
			return new ResponseEntity<Object>("Returns Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(check, HttpStatus.NOT_FOUND);
	}

}
