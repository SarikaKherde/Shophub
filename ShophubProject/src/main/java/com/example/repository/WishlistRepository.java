package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;
import com.example.entity.Wishlist;


public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
	Wishlist findByUser(User user);
}
