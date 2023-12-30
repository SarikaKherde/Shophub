package com.example.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.GiftCards;
import com.example.exceptionhandling.GiftCardsNotFoundException;
import com.example.repository.GiftCardsRepository;
import com.example.service.GiftCardsService;
@Service
public class GiftCardsServiceImpl implements GiftCardsService{

	@Autowired
	GiftCardsRepository giftCardsRepository;
	@Override
	public GiftCards addNewGiftCards(GiftCards giftCards) {
		// TODO Auto-generated method stub
		return giftCardsRepository.save(giftCards);
	}

	@Override
	public List<GiftCards> getAllGiftCards() {
		// TODO Auto-generated method stub
		return giftCardsRepository.findAll();
	}

	@Override
	public GiftCards findGiftCardsById(int id) throws GiftCardsNotFoundException {
		// TODO Auto-generated method stub
		 Optional<GiftCards> op1 =giftCardsRepository.findById(id);
		 if(op1.isPresent())
		 {
		     return giftCardsRepository.findById(id).get();
		 }
		 else 
			{
			   throw new GiftCardsNotFoundException("GiftCards is not avilable on this id");
		    }
	}

	@Override
	public String deleteGiftCardsById(int id) throws GiftCardsNotFoundException {
		// TODO Auto-generated method stub
		Optional<GiftCards> op2 =giftCardsRepository.findById(id);
		if(op2.isPresent())
		{
			giftCardsRepository.deleteById(id);
		     return "GiftCards deleted successfully";
	     }
		 else 
		{
			   throw new GiftCardsNotFoundException("GiftCards is not avilable on this id");
	    }
	}

}
