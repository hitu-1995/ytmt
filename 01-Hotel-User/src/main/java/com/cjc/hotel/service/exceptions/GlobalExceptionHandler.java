package com.cjc.hotel.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cjc.hotel.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> hotelNotFoundException(ResourceNotFoundException e) {

		ApiResponse apiResponse = ApiResponse.builder()
				                                    .msg(e.getMessage())
				                                    .httpStatus(HttpStatus.NOT_FOUND)
				                                    .success(false).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
	}
}
