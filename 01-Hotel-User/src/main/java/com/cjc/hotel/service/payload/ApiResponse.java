package com.cjc.hotel.service.payload;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {

	private String msg;
	private HttpStatus httpStatus;
	private boolean success;
	
}
