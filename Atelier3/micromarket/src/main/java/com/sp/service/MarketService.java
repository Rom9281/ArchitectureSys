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
	
	
	public ArrayList<CardDTO> getSellableMarketCards(String id) {
		Integer userid = Integer.valueOf(id);
		ArrayList<CardDTO> listeCardVente = (ArrayList<CardDTO>) Comm.getUserCards(userid);
		return listeCardVente;
	}
	
	
	public void buyCard(Integer buyerId, Integer cardId) {
		CardDTO cardDTO = Comm.getCardDTO(cardId);
		
		if (cardDTO.getIsToSell()) {  //TODO verif if card in market
			UserDTO owner = Comm.getUserDTO(cardDTO.getUserId());
			UserDTO buyer = Comm.getUserDTO(buyerId);
			
			if (buyer.getMoney() >= cardDTO.getPrice()) {
				buyer.setMoney(buyer.getMoney()-cardDTO.getPrice());
				owner.setMoney(owner.getMoney()+cardDTO.getPrice());
				cardDTO.setUserId(buyerId);
				Comm.putUpdateUser(buyer);// save le buyer en ajoutant la carte, enlevant sa money
				Comm.putUpdateCard(cardDTO);// save la carte avec l'id de son nouveau propriétaire
				Comm.putUpdateUser(owner);// save l'ancien proprio avec la carte enlevé de ses cartes, la money en plus
			}
			
		}
		
	}
}