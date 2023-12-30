package com.example.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Returns;
import com.example.exceptionhandling.ReturnNotFoundException;
import com.example.repository.ReturnsRepository;
import com.example.service.ReturnsService;

@Service
public class ReturnsServiceImpl implements  ReturnsService {

	@Autowired
	ReturnsRepository returnsRepository;

	@Override
	public Returns addReturns(Returns returns) {
		// TODO Auto-generated method stub
		return returnsRepository.save(returns);
	}

	@Override
	public List<Returns> getAllReturns() {
		// TODO Auto-generated method stub
		return returnsRepository.findAll();
	}

	@Override
	public Returns getReturnsById(int id) throws ReturnNotFoundException {
		// TODO Auto-generated method stub
		 Optional<Returns> op1 =returnsRepository.findById(id);
		 if(op1.isPresent())
		 {
		     return returnsRepository.findById(id).get();
		 }
		 else 
			{
			   throw new ReturnNotFoundException("Return is not avilable on this id");
		    }
	}

	@Override
	public String deleteReturnsById(int id) throws ReturnNotFoundException {
		// TODO Auto-generated method stub
		Optional<Returns> op2 =returnsRepository.findById(id);
		if(op2.isPresent())
		{
			returnsRepository.deleteById(id);
		     return "Returns deleted successfully";
	     }
		 else 
		{
			   throw new ReturnNotFoundException("Returns is not avilable on this id");
	    }
	}
}
