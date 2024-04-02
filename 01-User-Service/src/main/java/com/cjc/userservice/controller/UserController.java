package com.cjc.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.userservice.entities.User;
import com.cjc.userservice.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveUser(user));
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
		User user = service.getUser(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>>  getAllUsers() {
		List<User> list = service.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

}