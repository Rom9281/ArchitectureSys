package com.sp.rest;

  import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.CardDTO;
import com.model.CardFormDTO;
import com.sp.service.MarketService;
import antlr.collections.List;

  @RestController
  public class MarketRestCrt {
      @Autowired
      MarketService mService;
      
      // GET page de choix entre le market de vente, d'achat ou pour les rooms
      @GetMapping(value="/market")
      public void requestMarket() {
    	mService.requestMarketCard();
      }
      
      // GET pour obtenir l'affichage du market
      @RequestMapping(method=RequestMethod.GET,value="/market/buy")
      public void diplayMarket() {
    	  
	  }
      
      // GET pour avoir l'interface de vente des cartes de l'utilisateur connecté
      // TODO : doit renvoyer la liste des cartes de l'utilisateur connecté
      @GetMapping(value = "/market/sell")
      public ArrayList<CardDTO> sellMarket(@RequestBody Integer userId) {
    	  ArrayList<CardDTO> listeCards = mService.getSellableMarketCards();
    	  return listeCards;
      }
      
      // 
      @RequestMapping(method=RequestMethod.GET,value="/market/buy/{userId}/{cardId}")
      public void buyCard(@PathVariable Integer userId,@PathVariable Integer cardId) {
    	  // possiblement trouver un moyen de récupéré les deux variables autrement
    	  mService.buyCard(userId, cardId);
      }
      
    //----TODO----------------------------------------------------------------------------------------------------
      
      // url:/market/sell, affiche les cartes du joueur
      
      // bouton acheter sur une carte --> quand on appuie dessus--> GET infos utilisateur(id,argent) 
      //-->POST obj card "/user/acheter/id_card" 
      // 
    //--------------------------------------------------------------------------------------------------------    
   
  }
