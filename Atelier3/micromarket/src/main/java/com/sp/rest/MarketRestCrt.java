package com.sp.rest;

  import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

import com.model.CardFormDTO;
import com.sp.service.MarketService;
import antlr.collections.List;

  @RestController
  public class MarketRestCrt {
      @Autowired
      MarketService mService;
      
      @RequestMapping(method=RequestMethod.GET,value="/market")
      public void requestMarket() {
    	mService.requestMarketCard();
      }
      
      @RequestMapping(method=RequestMethod.POST,value="/market/buy")
      public List<CardFormDTO> diplayMarket(@RequestBody List<CardFormDTO> listCard) {
    	  return listCard;
	  }
      
      @RequestMapping(method=RequestMethod.GET,value="/market/buy/{userId}/{cardId}")
      public void buyCard(@PathVariable Integer userId,@PathVariable Integer cardId) {
    	  mService.buyCard(userId, cardId);
      }
      
    //----TODO----------------------------------------------------------------------------------------------------
      
      // url:/market/sell, affiche les cartes du joueur
      
      // bouton acheter sur une carte --> quand on appuie dessus--> GET infos utilisateur(id,argent) 
      //-->POST obj card "/user/acheter/id_card" 
      // 
    //--------------------------------------------------------------------------------------------------------    
   
  }
