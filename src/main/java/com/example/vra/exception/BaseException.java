package com.example.vra.exception;

public class BaseException extends RuntimeException {
 private final String message;

public BaseException(String message) {
	super();
	this.message = message;
}
}
