package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.User;
import com.example.vra.request.UserRequest;
import com.example.vra.response.UserResponse;
import com.example.vra.responsestructure.ResponseStructure;
import com.example.vra.service.UserService;

@RestController
public class UserController {
  private final UserService userService;

public UserController(UserService userService) {
	super();
	this.userService = userService;
}

//@PostMapping("/save-user")
//public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
//	user=userService.saveUser(user);
//	return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", user));
//}
@PostMapping("/save-user")
public ResponseEntity<ResponseStructure<UserResponse>> saveUser(@RequestBody UserRequest userRequest){
	 UserResponse userResponse=userService.saveUser(userRequest);
	return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Registered", userResponse));
}


}
