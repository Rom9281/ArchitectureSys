package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.sp.model.User;
import com.sp.repository.UserRepository;

import antlr.collections.List;
import reactor.core.publisher.Mono;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	// Creation d'un web client pour envoyer les requestes
	WebClient web_client_card = WebClient.builder()
	        .baseUrl("http://localhost:3000")
	        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	        .build();

	public void addUser(User u) {
		User createdUser = userRepository.save(u); // Sauvegarde du user dans la db
		
		System.out.println(createdUser);
		
		this.generateCard(createdUser.getId());
		
	}

	public User getUser(int id) {
		Optional<User> uOpt = userRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		} else {
			return null;
		}
	}
	
	public Iterable<User> getAllUser() {
		Iterable<User> uOpt = userRepository.findAll();
		return uOpt;
	}
	
	/**
	 * Requete pour generer les cartes lors de la création d'un utilisateur
	 * @PARAM User user
	 * @RETURN Integer Id
	 * */

	public void generateCard(Integer id) {
		// TODO : possiblement gerer le type de retour
		web_client_card.post()
		.uri("/generateCards")
		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		.body(Mono.just(id),Integer.class);
	}

}
