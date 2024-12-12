package com.example.vra.service;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.example.vra.entity.Image;
import com.example.vra.entity.User;
import com.example.vra.exception.UserNotFoundImageException;
import com.example.vra.exception.failedToUploadeException;
import com.example.vra.repository.ImageRepository;
import com.example.vra.repository.UserRepository;
@Controller
public class ImageService {
	private final ImageRepository imageRepository;
    private final UserRepository userRepository;
	public ImageService(ImageRepository imageRepository,UserRepository userRepository) {
		super();
		this.imageRepository = imageRepository;
		this.userRepository=userRepository;
	}
	
	public void uploadProfile(int userid, MultipartFile file) {
		
		Optional<User> optional=userRepository.findById(userid);
		if(optional.isPresent()) {
//			Image image=getImage(file);
			Image image=imageRepository.save(this.getImage(file));
			image =imageRepository.save(image);
			
			User user=optional.get();
			user.setProfilePicture(image);
			userRepository.save(user);
		}else {
			throw new UserNotFoundImageException("User Not found");
		}
		
	}

	private Image getImage(MultipartFile file) {
		
		try {
			Image image=new Image();
//			byte[] imageBytes=file.getBytes();
			image.setContentType(file.getContentType());
			image.setImageBytes(file.getBytes());
//			imageRepository.save(image);
			return image;
		}catch(Exception e) {
			throw new failedToUploadeException("Faild to upload Exception");
		}
		
	}
}
