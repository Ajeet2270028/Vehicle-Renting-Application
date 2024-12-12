package com.example.vra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.Image;
import com.example.vra.entity.User;
import com.example.vra.exception.UserNotFoundImageException;
import com.example.vra.exception.failedToUploadeException;
import com.example.vra.repository.ImageRepository;
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
