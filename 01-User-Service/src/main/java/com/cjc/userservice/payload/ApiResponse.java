package com.cjc.userservice.payload;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {

	private String msg;
	private boolean sucess;
	private HttpStatus status;
	
	
}
