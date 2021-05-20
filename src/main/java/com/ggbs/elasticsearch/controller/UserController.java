package com.ggbs.elasticsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ggbs.elasticsearch.model.User;
import com.ggbs.elasticsearch.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/findAll")
	public Iterable<User> findAllUsers() {
		return  userRepository.findAll();
	}

	@GetMapping("/findByFirstname/{firstName}")
	public Iterable<User> findUserByFirstname(@PathVariable String firstName) {
		return userRepository.findByFirstName(firstName);
	}

	
	@PostMapping("/saveUsers")
	public Integer saveUsers(@RequestBody List<User> users) {
		userRepository.saveAll(users);
		return users.size();
	}

	@GetMapping("/healthCheck")
	public String healthCheck() {
		return  " Elastic Search Example is up and running";
	}
	
}
