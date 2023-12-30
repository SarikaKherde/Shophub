package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Discount;
import com.example.exceptionhandling.DiscountNotFoundException;
import com.example.service.Impl.DiscountServiceImpl;

import jakarta.validation.Valid;

@RestController
public class DiscountController {
	//To Inject Bean of Class
	@Autowired
	DiscountServiceImpl discountServiceImpl;
	
	//To add discount
	@PostMapping("/discount")
	public ResponseEntity<Object> addDiscount(@Valid @RequestBody Discount discount)
	{
		Discount discount1 =discountServiceImpl.addDiscount(discount);
		return new ResponseEntity<>(discount1, HttpStatus.OK);
	}
    
	//To get discount entries
	@GetMapping("/discount")
	public List<Discount> findAllDiscounts()
	{
		return discountServiceImpl.getAllDiscount();
	}
	
	//To get discount entries by name
	@GetMapping("/discount/{discountName}")
	public ResponseEntity<Object> getDiscountByName(@PathVariable String discountName)
	{
		Discount discount =discountServiceImpl.getDiscountByDiscountName(discountName);
		if(discount != null)
		{
			return new ResponseEntity<Object>(discount,HttpStatus.FOUND);
		}
		Map<String, String> map = new HashMap<>();
		map.put("errorMessage", "Discount is not present");
		return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
	}
	
	//To update discount entries
	@PutMapping("/discount")
	public ResponseEntity<Object> updateDiscount(@RequestBody Discount discount)
	{
		Discount updates = discountServiceImpl.updateDiscountByName(discount); 
		if(updates != null)
		{
			return new ResponseEntity<Object>(discount,HttpStatus.OK);
		}
		Map<String, String> map = new HashMap<>();
		map.put("errorMessage", "discount is not present");
		return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
	}
	
	//To get discount entries by id
	@GetMapping("/discounts/{id}")
	public Discount findDiscountById(@PathVariable int id)throws DiscountNotFoundException {
		return  discountServiceImpl.getDiscountById(id);
	}
	
	//To delete discount entries
	@DeleteMapping("/discount/{discountName}")
	public ResponseEntity<Object> deleteDiscount(@PathVariable String discountName )
	{
		String check =discountServiceImpl.deleteDiscountByName(discountName);
		if(check != null)
		{
			return new ResponseEntity<Object>("Discount Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(check, HttpStatus.NOT_FOUND);
	}
}
