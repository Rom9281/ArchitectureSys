package com.sp.rest;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.CardDTO;
import com.model.CardFormDTO;
import com.sp.model.Card;
import com.sp.service.CardService;

import java.util.List;
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
      public void addCard(@RequestBody CardDTO cardDTO) {
    	  System.out.print(cardDTO);
          cService.addCard(cardDTO);
      }
      
      // Renvoie la carte avec l'id demandé
      @RequestMapping(method=RequestMethod.GET,value="/card/{id}")
      public CardDTO getCard(@PathVariable String id) {
    	  CardDTO cardDTO = cService.getCard(Integer.valueOf(id));
    	  System.out.println(cardDTO);
    	  return cardDTO;
      }

      // Requête pour récupérer toutes les cartes d'un utilisateur
      @GetMapping(value = "/card/user/{userId}")
      public List<CardDTO> getUserCards(@PathVariable Integer userId) {
    	  System.out.println("Récupération des cartes de l'utilisateur id=" + userId);
    	  return cService.getUserCards(userId);
      }
      
      // Attribuer des cartes pour l'utilisateur qui vient d'être créé
      @RequestMapping(method=RequestMethod.POST,value="/generateCards/{user_id}")
      public Integer generateCards(@PathVariable Integer userId) {
    	  System.out.println("Création de cartes pour l'utilisateur: id="+userId);
    	  System.out.println(userId);
    	  cService.createCards(userId);
    	  return userId;
      }
      
      
      @GetMapping("/card/market")
      public List<CardDTO> getMarketCards() {
    	  List<CardDTO> marketList = cService.cardsOfMarket();
    	  return marketList;
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/cards")
      public List<CardDTO> getCards() {
          List<CardDTO> clist =  cService.getAllCards();
          return clist;
      }
      
      @RequestMapping(method=RequestMethod.PUT,value="/card/{id}")
      public CardDTO updateCard(@PathVariable Integer id) {
    	  CardDTO cardDTO = cService.getCard(id);
    	  CardDTO updatedCardDTO = cService.update(id, cardDTO);
    	  return updatedCardDTO;
      }
  }
