package com.sp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CardDTO;
import com.model.CardFormDTO;
import com.model.UserDTO;
import com.sp.tools.Comm;

@Service
public class MarketService {

	
	public void requestMarketCard() {
		List<CardFormDTO> listeCardVente = new ArrayList<CardFormDTO>();
		//on cree un requete http
	}
	
	public List<CardFormDTO> getMarketCard() {
		List<CardFormDTO> listeCardVente = new ArrayList<CardFormDTO>();
		//on cree un requete http
		return listeCardVente;
	}
	
	public void buyCard(Integer buyerId, Integer cardId) {
		CardDTO card = Comm.getCardDTO(cardId);
		Integer ownerId = card.getUserId();
		UserDTO owner = Comm.get
		UserDTO buyer
	}
}