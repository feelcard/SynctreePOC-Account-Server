package com.kbfg.card.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kbfg.card.domain.Card;
import com.kbfg.card.repository.CardRepository;

@Service
public class CardService {
	
	@Inject
	CardRepository CardRepository;
	
	public List<Card> findbyCi(String ci){
		return CardRepository.findByCi(ci);
	}
	
	public List<Card> findAll(){
		return CardRepository.findAll();
	}

}
