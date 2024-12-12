package com.example.vra.responsestructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.vra.exception.UserNotFoundImageException;
import com.example.vra.exception.FailedToUploadeImageException;
import com.example.vra.exception.ImageNotfindByIdException;

@RestControllerAdvice
public class ApplicationExceptionHandle {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(UserNotFoundImageException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "User not find by id"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> faildToUploadImageException(FailedToUploadeImageException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "User profile upload to failed"));
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> ImageNotfindByIdException(ImageNotfindByIdException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "User profile upload to failed"));
	}
}
