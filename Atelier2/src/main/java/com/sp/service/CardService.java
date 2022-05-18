package com.sp.service;

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
	
	public Iterable<Card> getAllCards() {
		Iterable<Card> clist = cRepository.findAll();
		return clist;
	}
	
	public void createCard() {
		int min = 1;
		int max = 100;
		Card c1=new Card("Flippy", "Flippy est un l'un des personnages principaux de la série. Il est probablement le plus aimé du public, sa victoire au tournoi du meilleur personnage le prouvant. Il a sa propre série Ka-pow! Et est jouable dans le jeu vidéo False Alarm.", "Ours", "Armée", "https://static.wikia.nocookie.net/happy-tree-friends/images/e/e8/Flippy_m.jpg/revision/latest/scale-to-width-down/245?cb=20140208160639&path-prefix=fr", ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1));
		Card c2=new Card("Lumpy", "Lumpy fait partie des personnages éponymes de la série Happy Tree Friends. Il est un élan, le plus grand des personnages de la série.\n" + 
				"\n" + 
				"Au départ, Lumpy devait être un dinosaure. Au final, il a été décidé qu'il deviendrait un élan.", "Elan", "Dinosaure", "https://static.wikia.nocookie.net/happy-tree-friends/images/d/d6/Imagedelumpy2.jpg/revision/latest/scale-to-width-down/156?cb=20130529101041&path-prefix=fr", ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1));
		Card c3=new Card("Mr.Pickles", "Mr.Pickles est l'ami imaginaire de Lammy.", "Cornichon", "Chapeau","https://static.wikia.nocookie.net/happy-tree-friends/images/0/07/Imagecornichon.jpg/revision/latest/scale-to-width-down/230?cb=20130529180847&path-prefix=fr", ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1));
		Card c4=new Card("Lifty et Shifty", "Lifty et Shifty sont des frères jumeaux raton-laveurs kleptomanes. Pour ne pas les confondre, il faut savoir que Shifty est celui qui porte un chapeau, et Lifty, celui qui n'en porte pas ! ", "Raton-Laveur", "Voleur", "https://static.wikia.nocookie.net/happy-tree-friends/images/6/69/Liftyetshifty.jpg/revision/latest/scale-to-width-down/300?cb=20130929085951&path-prefix=fr",  ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1));
		Card c5=new Card("Cro-Marmot", "Cro-Marmot est une marmotte verte dans un grand cube de glace, il tient une batte en bois dans la main et une sorte de slip léopard sur lui. Ses cheveux cachent ses yeux.\n" + 
				"\n" + 
				"Bizzarement, Cro-Marmot sait faire plein de chose bien qu'il soit dans un bloc de glace, mais ses actions sont presque toujours élipsés. ", "Marmotte", "Taper",  "https://static.wikia.nocookie.net/happy-tree-friends/images/6/68/Cro-marmot_m.jpg/revision/latest/scale-to-width-down/271?cb=20140208161629&path-prefix=fr", ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1), ThreadLocalRandom.current().nextInt(min,max+1));
		addCard(c1);
		addCard(c2);
		addCard(c3);
		addCard(c4);
		addCard(c5);
	}
}