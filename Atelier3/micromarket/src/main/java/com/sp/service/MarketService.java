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
		List<CardDTO> listeCardVente = new ArrayList<CardDTO>();
		//on cree un requete http
	}
	
	public ArrayList<CardDTO> getSellableMarketCards() {
		
		ArrayList<CardDTO> listeCardVente = new ArrayList<CardDTO>();
		//on cree un requete http
		return listeCardVente;
	}
	
	public void buyCard(Integer buyerId, Integer cardId) {
		CardDTO card = Comm.getCardDTO(cardId);
		Integer ownerId = card.getUserId();
		UserDTO owner = Comm.getUserDTO(ownerId);
		UserDTO buyer = Comm.getUserDTO(buyerId);
		if (buyer.getMoney() >= card.getPrice()) {
			buyer.setMoney(buyer.getMoney()-card.getPrice());
			owner.setMoney(owner.getMoney()+card.getPrice());
			card.setUserId(buyerId);
			// save le buyer en ajoutant la carte, enlevant sa money
			// save la carte avec l'id de son nouveau propriétaire
			// save l'ancien proprio avec la carte enlevé de ses cartes, la money en plus
		}
	}
}