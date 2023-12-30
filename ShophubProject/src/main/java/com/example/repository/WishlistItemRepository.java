package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.WishlistItem;


public interface WishlistItemRepository extends JpaRepository<WishlistItem, Integer> {

}
