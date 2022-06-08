package com.sp.rest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.model.UserDTO;
import com.sp.model.User;
import com.sp.service.UserService;

/**
 * ! SECURITY THREAT:
 * Authoriser la cross origine policy porte atteinte a la securite,
 * a utiliser UNIQUEMENT POUR LES TEST!!!!!!!!!
 * */

@RestController
@CrossOrigin
public class UserRestCrt {
	@Autowired
	UserService uService;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/createUser")
	public boolean addUser(@RequestBody String json) {
		System.out.println("Lancement de la création d'un User");
		return uService.addUser(json);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public Iterable<User> getAllUser() {
		System.out.println("Lancement de la récupération de tous les users");
		Iterable<User> ulist = uService.getAllUser();
		return ulist;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{userId}")
	public UserDTO getUser(@PathVariable String userId) {
		System.out.println("Lancement de la récupération du User id="+userId);
		User u = uService.getUser(Integer.valueOf(userId));
		System.out.println(u);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(u, userDTO);
		return userDTO;
	}
	
	@PostMapping("/user/login")
	public Boolean login(@RequestBody String json){
		System.out.println("Lancement de la vérification du login");
		return uService.verifyUser(json);
	}
	
	@PutMapping("/user/update")
	public void updateUser(@RequestBody UserDTO userDTO) {
		System.out.println("Lancement de la mise à jour d'un User");
		uService.update(userDTO);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getUserInfo/{login}")
	public User getUserInfo(@PathVariable String login) {
		System.out.println("Lancement de la récupération des informations d'un User login="+login);
		return uService.getUserByLogin(login);
	}
	
}
