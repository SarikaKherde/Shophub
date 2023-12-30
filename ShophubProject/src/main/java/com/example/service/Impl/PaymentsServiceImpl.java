package com.example.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Payments;
import com.example.exceptionhandling.PaymentNotFoundException;
import com.example.repository.PaymentsRepository;
import com.example.service.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService{

	@Autowired
	PaymentsRepository paymentsRepository;

	@Override
	public Payments addPayments(Payments payments) {
		// TODO Auto-generated method stub
		return paymentsRepository.save(payments);
	}

	@Override
	public List<Payments> getAllPayments() {
		// TODO Auto-generated method stub
		return paymentsRepository.findAll();
	}

	@Override
	public Payments getPaymentsById(int id) throws PaymentNotFoundException {
		// TODO Auto-generated method stub
		 Optional<Payments> op1 =paymentsRepository.findById(id);
		 if(op1.isPresent())
		 {
		     return paymentsRepository.findById(id).get();
		 }
		 else 
			{
			   throw new PaymentNotFoundException("Payments is not avilable on this id");
		    }
	}

	@Override
	public String deletePaymentById(int id) throws PaymentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Payments> op2 =paymentsRepository.findById(id);
		if(op2.isPresent())
		{
			paymentsRepository.deleteById(id);
		     return "Payments deleted successfully";
	     }
		 else 
		{
			   throw new PaymentNotFoundException("Payments is not avilable on this id");
	    }
	}
}
