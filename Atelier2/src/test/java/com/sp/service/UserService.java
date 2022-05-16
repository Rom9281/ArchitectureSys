package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.User;
import com.sp.repository.UserRepository;

import antlr.collections.List;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public void addUser(User h) {
		User createdUser = userRepository.save(h);
		System.out.println(createdUser);
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

}
