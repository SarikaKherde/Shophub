package com.example.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Discount;
import com.example.exceptionhandling.DiscountNotFoundException;
import com.example.repository.DiscountRepository;
import com.example.service.DiscountService;
@Service
public class DiscountServiceImpl implements DiscountService {
	@Autowired
	DiscountRepository discountRepository;
    
	
	@Override
	public Discount addDiscount(Discount discount){
		// TODO Auto-generated method stub
	         return discountRepository.save(discount);
	}

	@Override
	public List<Discount> getAllDiscount() {
		// TODO Auto-generated method stub
		return discountRepository.findAll();
	}

	@Override
	public Discount getDiscountById(int id) throws DiscountNotFoundException {
		// TODO Auto-generated method stub
		 Optional<Discount> op1 = discountRepository.findById(id);
			if(op1.isPresent())
			{
			return discountRepository.findById(id).get();
		}
		else 
		{
		   throw new DiscountNotFoundException("Discount is not avilable on this id");
	    }
	}

	@Override
	public String deleteDiscountByName(String discountName) {
		// TODO Auto-generated method stub
		Discount discount = discountRepository.getDiscountByDiscountName(discountName);
		if(discount == null) {
		return null;
	}
		discountRepository.deleteById(discount.getDiscountID());
		return "Discount deleted successfully";
	}
	

	@Override
	public Discount updateDiscountByName(Discount discount) {
		// TODO Auto-generated method stub
		Discount existingDiscount = discountRepository.getDiscountByDiscountName(discount.getDiscountName());
		if(existingDiscount == null) {
		return null;
	}

		existingDiscount.setDiscountPercent(discount.getDiscountPercent());
	

		return discountRepository.save(existingDiscount);
	}

	@Override
	public Discount getDiscountByDiscountName(String discountName) {
		// TODO Auto-generated method stub
		return discountRepository.getDiscountByDiscountName(discountName);
	}

}
