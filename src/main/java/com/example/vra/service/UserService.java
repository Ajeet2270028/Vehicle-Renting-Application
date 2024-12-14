package com.example.vra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.vra.entity.User;
import com.example.vra.enums.UserRole;
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
  User user=userMapper.mapToUser(userRequest,new User());
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

public UserResponse registerCustomer(UserRequest userRequest, UserRole customer) {
	User user=userMapper.mapToUser(userRequest,new User());
	user.setRole(UserRole.CUSTOMER);
	return userMapper.mapToUserResponse(userrepository.save(user));
	
	
	
}

public UserResponse registerRentingPartner(UserRequest userRequest, UserRole rentingPartner) {
	User user=userMapper.mapToUser(userRequest,new User());
	user.setRole(UserRole.RENTING_PARTNER);
	return userMapper.mapToUserResponse(userrepository.save(user));
}

public UserResponse updateUserById(UserRequest userRequest, int userid) {
	Optional<User> optional=userrepository.findById(userid);
	if(optional.isPresent()) {
//		User user=optional.get();
		
		User user=userMapper.mapToUser(userRequest,optional.get());
		  User saveUser=userrepository.save(user);
		  
			return userMapper.mapToUserResponse(saveUser);
		
		
	}else {
		throw new UserNotFoundException("kjwfejkljo;lskl");
	}
}






}
