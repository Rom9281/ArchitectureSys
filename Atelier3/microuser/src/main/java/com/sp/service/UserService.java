package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.sp.model.User;
import com.sp.repository.UserRepository;

import antlr.collections.List;
import reactor.core.publisher.Mono;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	RestTemplate rest_Template = new RestTemplate();

	public void addUser(User u) {
		User createdUser = userRepository.save(u); // Sauvegarde du user dans la db
		
		System.out.println(createdUser);
		
		this.generateCards(createdUser.getId());
		
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
	public void generateCards(Integer id) {
		// TODO : possiblement gerer le type de retour
		System.out.println("Generation");
		
		
		System.out.println("done");
		
	}

}
