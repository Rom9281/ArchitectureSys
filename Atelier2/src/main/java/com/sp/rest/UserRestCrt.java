package com.sp.rest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.User;
import com.sp.model.UserFormDTO;
import com.sp.service.UserService;

@RestController
public class UserRestCrt {
	@Autowired
	UserService uService;

	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public void addUser(@RequestBody UserFormDTO userFormDTO) {
		User user = new User();
		BeanUtils.copyProperties(userFormDTO, user);
		
		uService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public Iterable<User> getAllUser() {
		Iterable<User> c = uService.getAllUser();
		return c;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	public User getUser(@PathVariable String id) {
		User c = uService.getUser(Integer.valueOf(id));
		return c;
	}
	

}
