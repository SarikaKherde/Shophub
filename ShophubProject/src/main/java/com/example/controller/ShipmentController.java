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

import com.example.entity.Shipment;
import com.example.exceptionhandling.ShipmentNotFoundException;
import com.example.service.Impl.ShipmentServiceImpl;

import jakarta.validation.Valid;

@RestController
public class ShipmentController {
	//To Inject Bean of Class
	@Autowired
	ShipmentServiceImpl shipmentServiceImpl;
	
	//To add shipment
	@PostMapping("/shipment")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public ResponseEntity<Object> addShipment(@Valid @RequestBody Shipment shipment)
	{
		Shipment shipment1 =shipmentServiceImpl.addShipment(shipment);
		return new ResponseEntity<>(shipment1, HttpStatus.OK);
	}
	
	//To get shipment
	@GetMapping("/shipment")
	public List<Shipment> findAllshipment()
	{
		return shipmentServiceImpl.getAllShipment();
	}
	
	//To get shipment by id
	@GetMapping("/shipment/{id}")
	public Shipment findShipmentById(@PathVariable int id)throws ShipmentNotFoundException {
		return shipmentServiceImpl.getShipmentById(id);
	}
	
	//To delete shipment by id
	@DeleteMapping("/shipment/{id}")
	public ResponseEntity<Object> deleteShipment(@PathVariable int id)throws ShipmentNotFoundException
	{
		String check = shipmentServiceImpl.deleteShipmentById(id);
		if(check != null)
		{
			return new ResponseEntity<Object>("Shipment Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(check, HttpStatus.NOT_FOUND);
	}
	
}
