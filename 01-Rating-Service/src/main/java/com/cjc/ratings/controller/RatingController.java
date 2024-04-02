package com.cjc.ratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.ratings.entities.Rating;
import com.cjc.ratings.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService service;

	@PostMapping("/")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {

		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveRating(rating));
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingByuserId(@PathVariable String userId) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllByUserId(userId));
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelId) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllByHotelId(hotelId));
	}

	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRatings() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllRatings());
	}

}
