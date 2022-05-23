package com.sp.rest;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

  import com.sp.model.Card;
  import com.sp.service.CardService;
import com.sp.service.MarketService;

import antlr.collections.List;

  @RestController
  public class MarketRestCrt {
      @Autowired
      MarketService mService;
      
      @RequestMapping(method=RequestMethod.GET,value="/market")
      public void addCard(@RequestBody List<CardFormDTO> listCard) {
    	  System.out.print(card);
    	  mService.afficherCard(card);
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/card")
      public Iterable<Card> getCards() {
          Iterable<Card> clist =  mService.getAllCards();
          return clist;
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/card/{id}")
      public Card getCard(@PathVariable String id) {
          Card c=mService.getCard(Integer.valueOf(id));
          return c;
      }
  }
