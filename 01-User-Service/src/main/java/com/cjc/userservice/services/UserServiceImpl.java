package com.cjc.userservice.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.cjc.userservice.entities.Hotel;
import com.cjc.userservice.entities.Rating;
import com.cjc.userservice.entities.User;
import com.cjc.userservice.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public User saveUser(User user) {
		
		 String randomUser = UUID.randomUUID().toString().toUpperCase();
		 user.setUid(randomUser);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		System.out.println("-----------------------------------------------");
		Rating[] ratingData = restTemplate.getForObject("http://localhost:8083/ratings/", Rating[].class);
		logger.info("{} ",ratingData);
		List<User> userList = userRepository.findAll();
	    List<Rating> ratingList = Arrays.asList(ratingData);
	  
	    userList.forEach(user -> {
            List<Rating> matchingRatings = ratingList.stream()
                    .filter(rating -> rating.getUserId().equals(user.getUid()))
                    .collect(Collectors.toList());
            user.setListOfRatings(matchingRatings);
        });

//	    for(User user : userList) {
//	    	  for(Rating rating:ratingData) {
//	        
//	    		     System.out.println(rating.getUserId() +" == "+user.getUid());
//	        	     if(rating.getUserId().equals(user.getUid()))
//	        	     {
//	        	    	 if(user.getListOfRatings()==null)
//	        	    		 user.setListOfRatings(new ArrayList<Rating>());
//	        	    	 
//	        	    	 user.get ListOfRatings().add(rating);
//	        	     }
//	        	     
//	          }	 
//	     }	
	 	return userList;
	}

	@Override
	public User getUser(String userId) {
		 User user = userRepository.findById(userId).orElseThrow(()-> new ResourceAccessException("Resource Not Found For ID "+userId));
		
		    List<Rating> ratingsOfUser= restTemplate.getForObject("http://localhost:8083/ratings/user/"+userId, List.class);
		      logger.info("{} "+ratingsOfUser);
		      user.setListOfRatings(ratingsOfUser);
	      
//		      list.forEach(System.out::println);
//
//		           List<Rating> ratingList = list.stream().map(rating -> {
//		           System.out.println("************ "+rating.getHotelId()+"  **************");
//		        Hotel hotel =	   restTemplate.getForObject("http://localhost:8082/hotels/"+rating.getRatingId(),Hotel.class);   
//		        rating.setHotel(hotel);
//		        
//		        return rating;
//		           }).collect(Collectors.toList());
//		       user.setListOfRatings(ratingList);
		      return user;
	}

	@Override
	public boolean deleteUser(String userId) {
		return false; 
	}
	
}
