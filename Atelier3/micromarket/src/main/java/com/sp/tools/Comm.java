package com.sp.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.model.CardDTO;
import com.model.UserDTO;

// C'est la classe des requêtes
public class Comm {
	
	private static final String URL_CARDSERVICE = "http://localhost:8083/card";
	private static final String URL_USERSERVICE = "http://localhost:8081/user";
	
	// URL: http://localhost:8083/card/id
	public static CardDTO getCardDTO(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		CardDTO card = restTemplate.getForObject(URL_CARDSERVICE+"/"+id, CardDTO.class);
		return card;
	}
	
	// URL: http://localhost:8081/user/{id}
	public static UserDTO getUserDTO(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		UserDTO user = restTemplate.getForObject(URL_USERSERVICE+"/"+id, UserDTO.class);
		return user;
	}
	
	// URL: http://localhost:8083/cards
	public static ArrayList<CardDTO> getUserCards(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<CardDTO> user = restTemplate.getForObject(URL_CARDSERVICE+"s/"+id, ArrayList.class);
		return user;
	}
	
	// URL: http://localhost:8083/card/market
	public static List<CardDTO> getCardsMarket() {
		RestTemplate restTemplate = new RestTemplate();
		CardDTO[] listcardDTO = restTemplate.getForObject(URL_CARDSERVICE+"/market", CardDTO[].class);
		List<CardDTO> listeCardVente = Arrays.asList(listcardDTO);
		return listeCardVente;
		}
}
