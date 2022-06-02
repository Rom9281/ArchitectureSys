package com.sp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.validation.Path.ReturnValueNode;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CardDTO;
import com.sp.model.Card;
import com.sp.repository.CardRepository;

import java.util.List;

@Service
public class CardService {
	@Autowired
	CardRepository cRepository;
	
	public CardDTO addCard(CardDTO cardDTO) {
		Card card = cardDTOToCard(cardDTO);
		Card createdCard=cRepository.save(card);
		System.out.println(createdCard);
		return cardToCardDTO(createdCard);
	}
	
	public CardDTO getCard(int id) {
		Optional<Card> cOpt =cRepository.findById(id);
		if (cOpt.isPresent()) {
			return cardToCardDTO(cOpt.get());
		}else {
			return null;
		}
	}
	
	public List<CardDTO> getAllCards() {
		List<Card> allCardsList = cRepository.findAll();
		ArrayList<CardDTO> allCardsDTOList = new ArrayList<CardDTO>();
		for (Card card : allCardsList) {
			allCardsDTOList.add(cardToCardDTO(card));
		}
		return allCardsDTOList;
	}
	
	public List<CardDTO> getUserCards(Integer userId) {
		List<Card> userCards = cRepository.findByUserId(userId);
		List<CardDTO> arrayUserCards = new ArrayList<CardDTO>();
		for (Card card : userCards) {
			arrayUserCards.add(this.cardToCardDTO(card));			
		}
		return arrayUserCards;
	}
	
	public List<CardDTO> createCards(Integer user_id) {
		int min = 1;
		int max = 100;
		ArrayList<CardDTO> generatedCardsList = new ArrayList<CardDTO>(); 
		CardDTO c1=new CardDTO("Flippy", "Flippy est un l'un des personnages principaux de la série. Il est probablement le plus aimé du public, sa victoire au tournoi du meilleur personnage le prouvant. Il a sa propre série Ka-pow! Et est jouable dans le jeu vidéo False Alarm.", "Ours", "Armée", "https://static.wikia.nocookie.net/happy-tree-friends/images/e/e8/Flippy_m.jpg/revision/latest/scale-to-width-down/245?cb=20140208160639&path-prefix=fr", ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1),user_id, false);
		CardDTO c2=new CardDTO("Lumpy", "Lumpy fait partie des personnages éponymes de la série Happy Tree Friends. Au départ, Lumpy devait être un dinosaure. Au final, il a été décidé qu'il deviendrait un élan.", "Elan", "Dinosaure", "https://static.wikia.nocookie.net/happy-tree-friends/images/d/d6/Imagedelumpy2.jpg/revision/latest/scale-to-width-down/156?cb=20130529101041&path-prefix=fr", ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1),user_id, false);
		CardDTO c3=new CardDTO("Mr.Pickles", "Mr.Pickles est l'ami imaginaire de Lammy.", "Cornichon", "Chapeau","https://static.wikia.nocookie.net/happy-tree-friends/images/0/07/Imagecornichon.jpg/revision/latest/scale-to-width-down/230?cb=20130529180847&path-prefix=fr", ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1),user_id, false);
		CardDTO c4=new CardDTO("Lifty et Shifty", "Lifty et Shifty sont des frères jumeaux raton-laveurs kleptomanes. Pour ne pas les confondre, il faut savoir que Shifty est celui qui porte un chapeau, et Lifty, celui qui n'en porte pas ! ", "Raton-Laveur", "Voleur", "https://static.wikia.nocookie.net/happy-tree-friends/images/6/69/Liftyetshifty.jpg/revision/latest/scale-to-width-down/300?cb=20130929085951&path-prefix=fr",  ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1),user_id, false);
		CardDTO c5=new CardDTO("Cro-Marmot", "Cro-Marmot est une marmotte verte dans un grand cube de glace, il tient une batte en bois dans la main et une sorte de slip léopard sur lui. Ses cheveux cachent ses yeux.\n", "Marmotte", "Taper",  "https://static.wikia.nocookie.net/happy-tree-friends/images/6/68/Cro-marmot_m.jpg/revision/latest/scale-to-width-down/271?cb=20140208161629&path-prefix=fr", ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1),user_id, false);
		generatedCardsList.add(c1);
		generatedCardsList.add(c2);
		generatedCardsList.add(c3);
		generatedCardsList.add(c4);
		generatedCardsList.add(c5);
		for (CardDTO cardDTO : generatedCardsList) {
			addCard(cardDTO);
		}
		return generatedCardsList;
	}
	
	public List<CardDTO> cardsOfMarket() {
		List<Card> marketCards = cRepository.findByIsToSellTrue();
		List<CardDTO> cardsDTOList = new ArrayList<CardDTO>();
		for (Card card : marketCards) {
			cardsDTOList.add(cardToCardDTO(card));
		}
		return cardsDTOList;
	}
	
	public CardDTO update(Integer id, CardDTO cardDTO) {
		Card card = cardDTOToCard(cardDTO);
		card.setId(id);
		Card updatedCard = cRepository.save(card);
		return cardToCardDTO(updatedCard);
	}
	
	public Card cardDTOToCard(CardDTO cardDTO) {
		Card card = new Card();
		BeanUtils.copyProperties(cardDTO,card);
		return null;
	}
	
	public CardDTO cardToCardDTO(Card card) {
		CardDTO cardDTO = new CardDTO();
		BeanUtils.copyProperties(card, cardDTO);
		return cardDTO;
	}
}