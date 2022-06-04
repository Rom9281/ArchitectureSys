package com.sp.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.UserDTO;
import com.sp.model.User;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; // Bibliotheque de securite
	
	RestTemplate rest_template = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	String url_generate_card = "http://127.0.0.1:8083/generateCards";
	
	ObjectMapper mapper = new ObjectMapper();
    
	
	/**
	 * Permet de convertir une chqine de charactere json recut en objet User
	 * @PARAM String string : chaine de charactere json
	 * @RETURN User : null si echec, un user sinon
	 * */
	public User json2User(String json) {
		try 
		{
			return mapper.readValue(json, User.class);
		} 
		catch(IOException e) 
		{
			System.out.println(e);
			return null;
		}
		
	}
	
	/**
	 * Permet d'ajouter un utilisateur en cryptant le mot de passe
	 * @throws IOException 
	 * @PARAM User u : utilisateur que l'on veut sauvegarder 
	 * @RETURN que nada
	 */
	public void addUser(User u) {
		System.out.println(u);
		/** Utilise le module de securite de spring pour crypter le mdp*/
		u.setPassword(passwordEncoder.encode(u.getPassword())); // Hashage du mdp
		
		/** Sauvegarde l'utilisateur creer dans la db*/
		User createdUser = userRepository.save(u); // Sauvegarde du user dans la db
		
		/** Demande a ce meme service de generer les cartes*/
		this.generateCards(createdUser.getId());
		
	}
	
	public boolean addUser(String json) {
		Boolean ret = false;
		User u = this.json2User(json);
		System.out.println(u);
		System.out.println(userRepository.findByLogin(u.getLogin()));
		
		
		/* Cherche a savoir si l'utilisateur existe deja dans la dB*/
		if(!userRepository.existsByLogin(u.getLogin())) {
			this.addUser(u);
			ret = true;
		}
		return ret;
		
	}
	
	/**
	 * Permet de savoir si l'utilisateur fait bien partie de la db
	 * */
	public boolean verifyUser(String json) {
		/** */
		boolean ret = false;
		User u = this.json2User(json); // convertis l'objet json en objet User
		
		if(u != null) { // si la conversion n'est pas un echec
			User same_login_u = this.getUserByLogin(u.getLogin()); // Recupere l'utilisateur avec un login meme que celui dont on demande la verification
			
			if(same_login_u != null) { // Si il a ete trouve
				ret = passwordEncoder.matches(u.getPassword(), same_login_u.getPassword());// verifie si il y a le meme mdp
			}
		}
		
		return ret;
	}

	public User getUser(Integer id) 
	{
		
		Optional<User> uOpt = userRepository.findById(id);
		
		if (uOpt.isPresent()) {
			return uOpt.get();
		} else {
			return null;
		}
	}
	
	public User getUserByLogin(String login) {
		Optional<User> uOpt = userRepository.findByLogin(login);
		if (uOpt.isPresent()) {
			return uOpt.get();
		} else {
			return null;
		}
	}

	public UserDTO update(Integer userId, UserDTO userDTO) {
		User user = userDTOToUser(userDTO);
		User updatedUser = userRepository.save(user);
		return userToUserDTO(updatedUser);
	}

	
	private User userDTOToUser(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		return user;
	}
	
	private UserDTO userToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);
		return userDTO;
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
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Integer> request = new HttpEntity<>(id, headers);
		rest_template.postForObject(url_generate_card+"/"+id.toString(), request, Integer.class);
		
		
	}

}
