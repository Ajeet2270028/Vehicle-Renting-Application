package com.example.vra.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.vra.exception.UserNotFoundImageException;
import com.example.vra.exception.failedToUploadeException;

@RestControllerAdvice
public class ApplicationExceptionHandle {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(UserNotFoundImageException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "User not found bu id"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> faildToFindException(failedToUploadeException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "User not found bu id"));
	}
}
