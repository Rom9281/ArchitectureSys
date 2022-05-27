package com.sp.rest;

  import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

  import com.sp.model.Card;
import com.sp.model.CardFormDTO;
import com.sp.service.CardService;

import antlr.collections.List;
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
      
      @RequestMapping(method=RequestMethod.POST,value="/card")
      public void addCard(@RequestBody CardFormDTO cardFormDTO) {
    	  System.out.print(cardFormDTO);
    	  Card card = new Card();
    	  BeanUtils.copyProperties(cardFormDTO, card);
          cService.addCard(card);
      
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
      
      @RequestMapping(method=RequestMethod.GET,value="/getCards")
      public Iterable<Card> getCards() {
          Iterable<Card> clist =  cService.getAllCards();
          return clist;
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/getCards/{id}")
      public Card getCard(@PathVariable String id) {
          Card c=cService.getCard(Integer.valueOf(id));
          return c;
      }
  }
