package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Integer> {

}
