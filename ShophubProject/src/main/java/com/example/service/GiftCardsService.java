package com.example.service;

import java.util.List;
import com.example.entity.GiftCards;
import com.example.exceptionhandling.GiftCardsNotFoundException;


public interface GiftCardsService {

	 public GiftCards addNewGiftCards(GiftCards giftCards);
	 
	 public List<GiftCards> getAllGiftCards();
	 
	 public GiftCards findGiftCardsById(int id)throws GiftCardsNotFoundException;
	 
	public String deleteGiftCardsById(int id)throws GiftCardsNotFoundException;
	

}
