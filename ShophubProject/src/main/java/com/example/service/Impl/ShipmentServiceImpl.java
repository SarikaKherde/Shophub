package com.example.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Shipment;
import com.example.exceptionhandling.ShipmentNotFoundException;
import com.example.repository.ShipmentRepository;
import com.example.service.ShipmentService;
@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	ShipmentRepository shipmentRepository;
	
	@Override
	public Shipment addShipment(Shipment shipment) {
		// TODO Auto-generated method stub
		return shipmentRepository.save(shipment);
	}

	@Override
	public List<Shipment> getAllShipment() {
		// TODO Auto-generated method stub
		return shipmentRepository.findAll();
	}

	@Override
	public Shipment getShipmentById(int id) throws ShipmentNotFoundException {
		// TODO Auto-generated method stub
		 Optional<Shipment> op1 =shipmentRepository.findById(id);
		 if(op1.isPresent())
		 {
		     return shipmentRepository.findById(id).get();
		 }
		 else 
			{
			   throw new ShipmentNotFoundException("Shipment is not avilable on this id");
		    }
	}
	

	@Override
	public String deleteShipmentById(int id) throws ShipmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Shipment> op2 =shipmentRepository.findById(id);
		if(op2.isPresent())
		{
			shipmentRepository.deleteById(id);
		     return "Shipment deleted successfully";
	     }
		 else 
		{
			   throw new ShipmentNotFoundException("Shipment is not avilable on this id");
	    }
	}

}
