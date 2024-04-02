package com.cjc.ratings.service;

import java.util.List;

import com.cjc.ratings.entities.Rating;

public interface RatingService {

	Rating saveRating(Rating rating);
	
	List<Rating> getAllRatings();
	
	List<Rating> getAllByUserId(String userId);
	
	List<Rating> getAllByHotelId(String userId);
	
}
