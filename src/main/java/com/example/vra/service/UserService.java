package com.example.vra.service;

import org.springframework.stereotype.Service;

import com.example.vra.entity.User;
import com.example.vra.mapping.UserMapper;
import com.example.vra.repository.UserRepository;
import com.example.vra.request.UserRequest;
import com.example.vra.response.UserResponse;

@Service
public class UserService {
  private final UserRepository userrepository;
  private final UserMapper userMapper;
public UserService(UserRepository userrepository,UserMapper userMapper) {
	super();
	this.userrepository = userrepository;
	this.userMapper=userMapper;
	
}

public UserResponse saveUser(UserRequest userRequest) {
  User user=userMapper.mapToUser(userRequest);
  User saveUser=userrepository.save(user);
	return userMapper.mapToUserResponse(saveUser);
}
//public User saveUser(User user) {
//	
//	return userrepository.save(user);
//}


}
