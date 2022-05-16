package com.sp.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;

@Service
public class CardService {
	@Autowired
	CardRepository cRepository;
	
	public void addCard(Card c) {
		Card createdCard=cRepository.save(c);
		System.out.println(createdCard);
	}
	
	public Card getCard(int id) {
		Optional<Card> cOpt =cRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}else {
			return null;
		}
	}
	
	public Card createCard() {
		int min = 1;
		int max = 100;
		Card c1=new Card("Flippy", "Flippy est un l'un des personnages principaux de la série. Il est probablement le plus aimé du public, sa victoire au tournoi du meilleur personnage le prouvant. Il a sa propre série Ka-pow! Et est jouable dans le jeu vidéo False Alarm.", "Ours", "Armée", "https://static.wikia.nocookie.net/happy-tree-friends/images/e/e8/Flippy_m.jpg/revision/latest/scale-to-width-down/245?cb=20140208160639&path-prefix=fr", ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1));
		Card c2=new Card("Lumpy", "Lumpy fait partie des personnages éponymes de la série Happy Tree Friends. Il est un élan, le plus grand des personnages de la série.\n" + 
				"\n" + 
				"Au départ, Lumpy devait être un dinosaure. Au final, il a été décidé qu'il deviendrait un élan.", "Elan", "Dinosaure", "https://static.wikia.nocookie.net/happy-tree-friends/images/d/d6/Imagedelumpy2.jpg/revision/latest/scale-to-width-down/156?cb=20130529101041&path-prefix=fr", ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1));
		Card c3=new Card("Anna", "orange", "super music girl", "http://ekladata.com/fMJl--_v-3CmisaynTHju1DMeXE.gif");
		Card c4=new Card("Angry Joe", "purple", "super angry power", "http://ekladata.com/AmbNNNvv-4YFEMZR8XD8e54WoHc.gif");
		Card c5=new Card("Ursula", "green", "super cloning power", "http://ekladata.com/CXJhi2YLUbNz6__e0Ct6ZP-XOds.gif");
		return c1;
	}
}