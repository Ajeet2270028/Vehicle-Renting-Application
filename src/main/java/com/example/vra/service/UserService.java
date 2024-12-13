package com.example.vra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.vra.entity.User;
import com.example.vra.exception.UserNotFoundException;
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

public UserResponse findUser(int userid) {
	Optional<User> optinal=userrepository.findById(userid);
	if(optinal.isPresent()) {
		User user=optinal.get();
		UserResponse response=userMapper.mapToUserResponse(user);
		this.setProfilePictureURL(response,user.getUserid());
		
		return response;
	}else {
		throw new UserNotFoundException("User not Found");
	}
}

private void setProfilePictureURL(UserResponse response,int userid) {
	int imageid=userrepository.getProfilePictureByuserid(userid);
	if(imageid>0) {
		response.setProfilePicture("/get-userProfile-picture?imageid="+imageid);
	}
}




}
