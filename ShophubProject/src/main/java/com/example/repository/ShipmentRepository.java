package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Shipment;


public interface ShipmentRepository extends JpaRepository<Shipment, Integer>{

}
