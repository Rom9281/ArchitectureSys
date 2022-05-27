package com.sp.tools;

import org.springframework.web.client.RestTemplate;

import com.model.CardDTO;
import com.model.UserDTO;

// C'est la classe des requêtes
public class Comm {
	
	private static final String URL_CARDSERVICE = "http://localhost:8080/card";
	private static final String URL_USERSERVICE = "http://localhost:8081/user";
	
	public static CardDTO getCardDTO(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		CardDTO card = restTemplate.getForObject(URL_CARDSERVICE+"/"+id, CardDTO.class);
		return card;
	}
	
	public static UserDTO getUserDTO(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		UserDTO user = restTemplate.getForObject(URL_USERSERVICE+"/"+id, UserDTO.class);
		return user;
	}
}
