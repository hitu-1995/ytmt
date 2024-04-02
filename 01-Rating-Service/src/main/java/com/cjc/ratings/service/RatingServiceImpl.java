package com.cjc.ratings.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.ratings.entities.Rating;
import com.cjc.ratings.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository repo;
	
	@Override
	public Rating saveRating(Rating rating) {
		String ratingId = UUID.randomUUID().toString().toUpperCase();
		 rating.setRatingId(ratingId);
		return repo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return repo.findAll();
	}

	@Override
	public List<Rating> getAllByUserId(String userId) {
		return repo.findAllByUserId(userId);
	}

	@Override
	public List<Rating> getAllByHotelId(String userId) {
		return repo.findAllByHotelId(userId);
	}

}
