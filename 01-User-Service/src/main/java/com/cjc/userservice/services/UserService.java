package com.cjc.userservice.services;

import java.util.List;

import com.cjc.userservice.entities.User;

public interface UserService {

	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);

    boolean deleteUser(String userId);
}
