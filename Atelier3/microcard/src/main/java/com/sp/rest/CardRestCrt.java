package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sp.model.Card;
import com.sp.service.CardService;


  @RestController
  public class CardRestCrt {	
      @Autowired
      CardService cService;
      
      
      @RequestMapping(method=RequestMethod.POST,value="/generateCards/{user_id}")
      public Integer generateCards(@PathVariable Integer user_id ) {
    	  System.out.println("Reception");
    	  System.out.println(user_id);
    	  cService.createCards(user_id);
    	  return user_id;
      }
      
//TODO--------------------------------------------------------------------------------------------------------
      //Reception requete http du market + envoie http de la liste des cards id = 0
//--------------------------------------------------------------------------------------------------------    
      
      @RequestMapping(method=RequestMethod.GET,value="/card")
      public Iterable<Card> getCards() {
          Iterable<Card> clist =  cService.getAllCards();
          return clist;
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/card/{id}")
      public Card getCard(@PathVariable String id) {
          Card c=cService.getCard(Integer.valueOf(id));
          return c;
      }
  }
