package com.cjc.hotel.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String string) {
		super(string);
	}
	public ResourceNotFoundException() {
	  super("Hotel Not Found");
	}


}
