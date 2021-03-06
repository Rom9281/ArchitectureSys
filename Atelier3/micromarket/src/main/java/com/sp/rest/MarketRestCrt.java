package com.sp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.CardDTO;
import com.model.UserDTO;
import com.sp.service.MarketService;

@RestController
public class MarketRestCrt {

	@Autowired
	MarketService mService;

	// GET pour obtenir l'affichage du market des cartes achetables
	@RequestMapping(method = RequestMethod.GET, value = "/market/buy")
	public List<CardDTO> diplayMarketBuy() {
		System.out.println("Lancement récupération cartes en vente");
		List<CardDTO> uList = mService.requestMarketCard();
		return uList;
	}

	// GET pour avoir l'interface de vente des cartes de l'utilisateur connecté
	@GetMapping(value = "/market/sell/{userid}")
	public List<CardDTO> sellMarket(@PathVariable String userid) {
		System.out.println("Lancement récupération cartes de l'utilisateur pour mise en vente");
		List<CardDTO> listeCards = mService.getSellableMarketCards(userid);
		return listeCards;
	}

	//
	@RequestMapping(method = RequestMethod.GET, value = "/market/buy/{userId}/{cardId}")
	public Boolean buyCard(@PathVariable String userId, @PathVariable String cardId) {
		System.out.println("Lancement achat d'une carte");
		Boolean ret = mService.buyCard(Integer.valueOf(userId), Integer.valueOf(cardId));
		return ret;
	}

}
