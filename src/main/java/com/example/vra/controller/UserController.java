package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.vra.entity.User;
import com.example.vra.response.ResponseStructure;
import com.example.vra.service.UserService;

@Controller
public class UserController {
  private final UserService userService;

public UserController(UserService userService) {
	super();
	this.userService = userService;
}
@PostMapping("/save-user")
public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
	user=userService.saveUser(user);
	return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", user));
}
}
