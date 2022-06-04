package com.sp.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.model.CardDTO;
import com.model.UserDTO;

// C'est la classe des requêtes
public class Comm {

	private static final String URL_CARDSERVICE = "http://localhost:8083/card";
	private static final String URL_USERSERVICE = "http://localhost:8081/user";

	// GET: http://localhost:8083/card/{id}
	public static CardDTO getCardDTO(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		CardDTO card = restTemplate.getForObject(URL_CARDSERVICE + "/" + id, CardDTO.class);
		return card;
	}

	// GET: http://localhost:8081/user/{id}
	public static UserDTO getUserDTO(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		UserDTO user = restTemplate.getForObject(URL_USERSERVICE + "/" + id, UserDTO.class);
		return user;
	}

	// GET: http://localhost:8083/card/user/{id}
	public static ArrayList<CardDTO> getUserCards(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<CardDTO> user = restTemplate.getForObject(URL_CARDSERVICE + "/" + id, ArrayList.class);
		return user;
	}

	// GET: http://localhost:8083/card/market
	public static List<CardDTO> getCardsMarket() {
		System.out.println("Demande des cartes en vente actuellement");
		RestTemplate restTemplate = new RestTemplate();
		CardDTO[] listcardDTO = restTemplate.getForObject(URL_CARDSERVICE + "/market", CardDTO[].class);
		List<CardDTO> listeCardVente = Arrays.asList(listcardDTO);
		return listeCardVente;
	}
	
	/**
	 * Fonction pour changer une carte:
	 * Utile pour :
	 * 		- les actions de vente de carte par un utilisateur
	 * 		- l'achat d'une carte par un joueur depuis le market
	 * @param cardDTO
	 */
	// PUT: http://localhost:8083/card/{id}
	public static void putUpdateCard(CardDTO cardDTO) {
		System.out.println("On met à jour la carte "+cardDTO);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<CardDTO> requestBody = new HttpEntity<>(cardDTO, headers);
		restTemplate.put(URL_CARDSERVICE + "/"+cardDTO.getId(), requestBody, Boolean.class);
	}
	
}
