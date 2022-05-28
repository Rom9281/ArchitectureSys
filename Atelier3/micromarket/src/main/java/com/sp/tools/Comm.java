package com.sp.tools;

import java.util.ArrayList;

import org.springframework.web.client.RestTemplate;

import com.model.CardDTO;
import com.model.UserDTO;

// C'est la classe des requêtes
public class Comm {
	
	private static final String URL_CARDSERVICE = "http://localhost:8080/card";
	private static final String URL_USERSERVICE = "http://localhost:8081/user";
	
	// URL: http://localhost:8080/card/id
	public static CardDTO getCardDTO(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		CardDTO card = restTemplate.getForObject(URL_CARDSERVICE+"/"+id, CardDTO.class);
		return card;
	}
	
	// URL: http://localhost:8080/user/{id}
	public static UserDTO getUserDTO(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		UserDTO user = restTemplate.getForObject(URL_USERSERVICE+"/"+id, UserDTO.class);
		return user;
	}
	
	// URL: http://localhost:8080/cards
	public static ArrayList<CardDTO> getUserCards(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<CardDTO> user = restTemplate.getForObject(URL_CARDSERVICE+"s/"+id, ArrayList.class);
		return user;
	}
}
