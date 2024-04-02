package com.cjc.userservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		// TODO Auto-generated constructor stub
		super("Resource Not Found on server!");
	}

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
