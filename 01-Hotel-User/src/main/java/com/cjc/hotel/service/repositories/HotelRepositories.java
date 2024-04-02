package com.cjc.hotel.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.hotel.service.entities.Hotel;

@Repository
public interface HotelRepositories extends JpaRepository<Hotel,String>{

	
}
