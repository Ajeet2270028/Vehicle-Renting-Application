package com.example.vra.service;

import org.springframework.stereotype.Service;

import com.example.vra.entity.User;
import com.example.vra.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userrepository;
  
public UserService(UserRepository userrepository) {
	super();
	this.userrepository = userrepository;
	
}

public User saveUser(User user) {

	return userrepository.save(user);
}


}
