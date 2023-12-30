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

import com.example.entity.GiftCards;

import com.example.exceptionhandling.GiftCardsNotFoundException;
import com.example.service.Impl.GiftCardsServiceImpl;

import jakarta.validation.Valid;
@RestController
public class GiftCardsController {
	//To Inject Bean of Class
	@Autowired 
	GiftCardsServiceImpl giftCardsServiceImpl;
	
	//To add GiftCards
	@PostMapping("/giftCards")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public ResponseEntity<Object> addGiftCards(@Valid @RequestBody GiftCards giftCards)
	{
		GiftCards giftCards1 =giftCardsServiceImpl.addNewGiftCards(giftCards);
		return new ResponseEntity<>(giftCards1, HttpStatus.OK);
	}
	
	//To get GiftCards
	@GetMapping("/giftCards")
	public List<GiftCards> findAllgiftCards()
	{
		return giftCardsServiceImpl.getAllGiftCards();
	}
	
	//To get GiftCards by id
	@GetMapping("/giftCards/{id}")
	public GiftCards findGiftCardsById(@PathVariable int id)throws GiftCardsNotFoundException {
		return giftCardsServiceImpl.findGiftCardsById(id);
	}
	
	//To delete GiftCards
	@DeleteMapping("/giftCards/{id}")
	public ResponseEntity<Object> deleteGiftCards(@PathVariable int id)throws GiftCardsNotFoundException
	{
		String check = giftCardsServiceImpl.deleteGiftCardsById(id);
		if(check != null)
		{
			return new ResponseEntity<Object>("GiftCards Deleted", HttpStatus.OK);
		}
		return new ResponseEntity<Object>(check, HttpStatus.NOT_FOUND);
	}

}
