package com.cjc.hotel.service.hotelervice;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.hotel.service.entities.Hotel;
import com.cjc.hotel.service.exceptions.ResourceNotFoundException;
import com.cjc.hotel.service.repositories.HotelRepositories;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepositories hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString().toUpperCase();
		hotel.setHotelId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel Not found for ID " + hotelId));
	}

}
