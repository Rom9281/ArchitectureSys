package com.sp.rest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
    	  System.out.print("Lancement de l'ajout dans la base de données de la carte: "+cardDTO);
          cService.addCard(cardDTO);
      }
      
      // Renvoie la carte avec l'id demandé
      @RequestMapping(method=RequestMethod.GET,value="/card/{cardId}")
      public CardDTO getCard(@PathVariable String cardId) {
    	  System.out.println("Lancement de la méthode de récupération de la carte id="+cardId);
    	  CardDTO cardDTO = cService.getCard(Integer.valueOf(cardId));
    	  System.out.println("Carte récupéré :"+cardDTO);
    	  return cardDTO;
      }

      // Requête pour récupérer toutes les cartes d'un utilisateur
      @GetMapping(value = "/card/user/{userId}")
      public List<CardDTO> getUserCards(@PathVariable String userId) {
    	  System.out.println("Lancement de la récupération des cartes de l'utilisateur id="+userId);
    	  return cService.getUserCards(Integer.valueOf(userId));
      }
      
      // Attribuer des cartes pour l'utilisateur qui vient d'être créé
      @RequestMapping(method=RequestMethod.GET,value="/generateCards/{userId}")
      public List<CardDTO> generateCards(@PathVariable String userId) {
    	  System.out.println("Lancement de la création de cartes pour l'utilisateur: id="+userId);
    	  List<CardDTO> generatedCardsList = cService.createCards(Integer.valueOf(userId));
    	  return generatedCardsList;
      }
      
      
      @GetMapping("/card/market")
      public List<CardDTO> getMarketCards() {
    	  System.out.println("Lancement de l'obtention des cartes du market");
    	  List<CardDTO> marketList = cService.cardsOfMarket();
    	  return marketList;
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/cards")
      public List<CardDTO> getCards() {
    	  System.out.println("Lancement de la récupération de toutes les cartes");
          List<CardDTO> clist =  cService.getAllCards();
          return clist;
      }
      
      @RequestMapping(method=RequestMethod.PUT,value="/card/{cardId}")
      public CardDTO updateCard(@PathVariable String cardId, @RequestBody CardDTO cardDTO) {
    	  CardDTO updatedCardDTO = cService.update(cardDTO);
    	  return updatedCardDTO;
      }
      
  }
