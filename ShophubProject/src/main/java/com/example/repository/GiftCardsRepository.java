package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.GiftCards;


public interface GiftCardsRepository extends JpaRepository<GiftCards, Integer> {

}
