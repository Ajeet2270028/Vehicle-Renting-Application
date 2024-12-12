package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.User;
import com.example.vra.response.ResponseStructure;
import com.example.vra.service.ImageService;
import com.example.vra.service.UserService;

@Controller
public class ImageController {
  private final  ImageService imageService;

public ImageController(ImageService imageService) {
	super();
	this.imageService = imageService;
}

@PostMapping("/upload-image")
public ResponseEntity<ResponseStructure<User>> uploadProfile(@RequestParam int userid, @RequestParam MultipartFile file){
	imageService.uploadProfile(userid,file);
	return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.create(HttpStatus.CREATED.value(), "Profile Image Uploade"));
}
}
