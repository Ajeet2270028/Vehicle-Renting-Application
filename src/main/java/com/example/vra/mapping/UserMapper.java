package com.example.vra.mapping;

import org.springframework.stereotype.Component;

import com.example.vra.entity.User;
import com.example.vra.request.UserRequest;
import com.example.vra.response.UserResponse;
@Component
public class UserMapper {
   
	
	public User mapToUser(UserRequest request) {
		User user=new User();
		
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setRole(request.getRole());
		user.setPassword(request.getPassword());
		
		return user;
		
	}
	
	public UserResponse mapToUserResponse(User user) {
		  UserResponse response=new UserResponse();
		  response.setUserid(user.getUserid());
		  response.setUsername(user.getUsername());
		  response.setEmail(user.getEmail());
		  response.setPhoneNumber(user.getPhoneNumber());
		  response.setRole(user.getRole());
//		  response.setProfilePicture("get-userProfile-picture?userid"+user.getProfilePicture().getImageid());
		  return response;
	}
}
