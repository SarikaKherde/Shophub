package com.example.service;

import java.util.List;
import com.example.entity.Shipment;
import com.example.exceptionhandling.ShipmentNotFoundException;

public interface ShipmentService {

	public Shipment addShipment(Shipment shipment);
    public List<Shipment> getAllShipment();
	public Shipment getShipmentById(int id)throws ShipmentNotFoundException;
	public String deleteShipmentById(int id)throws ShipmentNotFoundException;
}
