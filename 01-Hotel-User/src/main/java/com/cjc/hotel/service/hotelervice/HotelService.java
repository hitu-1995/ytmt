package com.cjc.hotel.service.hotelervice;

import java.util.List;

import com.cjc.hotel.service.entities.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);

	List<Hotel> getAllHotel();
	
	Hotel getHotel(String hotelId);
	
}
