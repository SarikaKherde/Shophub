package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
