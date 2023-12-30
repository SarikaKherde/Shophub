package com.example.service;

import java.util.List;
import com.example.entity.Discount;
import com.example.exceptionhandling.DiscountNotFoundException;

public interface DiscountService {
	
	public Discount addDiscount(Discount discount);
	
	public List<Discount> getAllDiscount();
	
	public Discount getDiscountById(int id)throws DiscountNotFoundException;
	
	public String deleteDiscountByName(String discountName);
	
	public Discount updateDiscountByName(Discount discount);
	
	public Discount getDiscountByDiscountName(String discountName);

}
