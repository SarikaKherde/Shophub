package com.example.service;

import java.util.List;
import com.example.entity.Payments;
import com.example.exceptionhandling.PaymentNotFoundException;


public interface PaymentsService {
	public Payments addPayments(Payments payments);
    public List<Payments> getAllPayments();
	public Payments getPaymentsById(int id)throws PaymentNotFoundException;
	public String deletePaymentById(int id)throws PaymentNotFoundException;
}
