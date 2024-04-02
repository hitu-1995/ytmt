package com.cjc.ratings.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.ratings.entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String>{

	List<Rating> findAllByUserId(String userId);
	List<Rating> findAllByHotelId(String userId);

	
}
