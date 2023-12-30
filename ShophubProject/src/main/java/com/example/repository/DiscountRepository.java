package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {
	public Discount getDiscountByDiscountName(String discountName);
}
