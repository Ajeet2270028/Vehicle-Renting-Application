package com.example.vra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.Image;
import com.example.vra.response.SimpleResponseStructure;
import com.example.vra.service.ImageService;

@RestController
public class ImageController {
  private final  ImageService imageService;

public ImageController(ImageService imageService) {
	super();
	this.imageService = imageService;
}

@PostMapping("/upload-image")
public ResponseEntity<SimpleResponseStructure> uploadProfile(@RequestParam int userid, @RequestParam MultipartFile file){
	imageService.uploadProfile(userid,file);
	return ResponseEntity.status(HttpStatus.CREATED).body(SimpleResponseStructure.create(HttpStatus.CREATED.value(), "Profile Image Uploade"));
}

@GetMapping("/get-userProfile-picture")
public ResponseEntity<byte[]> getImagefetch(@RequestParam int imageid){
	Image image=imageService.getImage(imageid);
	return ResponseEntity.status(HttpStatus.OK)
			.contentType(MediaType.valueOf(image.getContentType())).body(image.getImageBytes());
}
}
