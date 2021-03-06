package com.sp.rest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;
import com.sp.model.CardFormDTO;
import com.sp.service.CardService;

import antlr.collections.List;

  @RestController
  public class CardRestCrt {
      @Autowired
      CardService cService;
      
      @RequestMapping(method=RequestMethod.POST,value="/card")
      public void addCard(@RequestBody CardFormDTO cardDto) {
    	  System.out.print(cardDto);
    	  
    	  Card card = new Card();
    	  BeanUtils.copyProperties(cardDto, card);
    	  if (cardDto.getId_user() == 0) {
    		  // associer la carte au market
    		  
    	  }
    	  else {
			// Si l'id de user existe, lui attribuer
    	  }
          cService.addCard(card);
      }
      
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
