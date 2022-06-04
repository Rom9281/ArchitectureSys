package com.sp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.validation.Path.ReturnValueNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.model.CardDTO;
import com.model.CardFormDTO;
import com.model.UserDTO;
import com.sp.tools.Comm;

@Service
public class MarketService {

	
	public List<CardDTO> requestMarketCard() {
		
		List<CardDTO> listeCardVente = Comm.getCardsMarket();
		System.out.println(listeCardVente);
		return listeCardVente;
		}
	
	
	public ArrayList<CardDTO> getSellableMarketCards() {
		
		ArrayList<CardDTO> listeCardVente = new ArrayList<CardDTO>();
		//on cree un requete http
		return listeCardVente;
	}
	
	public void buyCard(Integer buyerId, Integer cardId) {
		CardDTO cardDTO = Comm.getCardDTO(cardId);
		UserDTO owner = Comm.getUserDTO(cardDTO.getUserId());
		UserDTO buyer = Comm.getUserDTO(buyerId);
		if (buyer.getMoney() >= cardDTO.getPrice()) {
			buyer.setMoney(buyer.getMoney()-cardDTO.getPrice());
			owner.setMoney(owner.getMoney()+cardDTO.getPrice());
			cardDTO.setUserId(buyerId);
			
			// save le buyer en ajoutant la carte, enlevant sa money
			// save la carte avec l'id de son nouveau propriétaire
			// save l'ancien proprio avec la carte enlevé de ses cartes, la money en plus
		}
	}
}