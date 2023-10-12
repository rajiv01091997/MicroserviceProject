package com.globallogic.Services;


import ch.qos.logback.core.CoreConstants;
import com.globallogic.Entity.Hotel;
import com.globallogic.Entity.Rating;
import com.globallogic.Entity.User;
import com.globallogic.Exception.IdNotFoundException;
import com.globallogic.Feign.HotelService;
import com.globallogic.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
   @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private com.globallogic.Feign.Service service;

    @Autowired
    private HotelService hotelService;

    @Override
    public User saveUser(User user) {
       String id= UUID.randomUUID().toString();
       user.setUserId(id);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser()
    {

       List<User> list=userRepository.findAll();
       for(User user:list)
       {
           //microservice calling using FEIGN CLIENT
       List<Rating> rating=service.getRatingsUsingfeign(user.getUserId());
       for(Rating rate:rating)
       {
              //microservice calling using FEIGN CLIENT
           Hotel hotel=hotelService.getHotelByFeign(rate.getHotelId());
           rate.setHotel(hotel);
       }
       user.setRatings(rating);
       }
        return  list;
    }

    @Override
    public User getUser(String UserId) {
        if(userRepository.findById(UserId).isEmpty())
            throw new IdNotFoundException("This User Id is not found");
        //fetching ratings of this particular user from Rating-Service by calling its API USING RESTTEMPLATE

      // ArrayList ratings=restTemplate.getForObject("http://localhost:8083/ratings/users/"+UserId, ArrayList.class);
        Rating[] ratings=restTemplate.getForObject("http://Rating-Service/ratings/users/"+UserId, Rating[].class);

    List<Rating> ratings1= Arrays.stream(ratings).toList();
        for(Rating rate:ratings1)
        {
            Hotel hotel=restTemplate.getForObject("https://Hotel-Service/hotels/"+rate.getHotelId(), Hotel.class);
            rate.setHotel(hotel);
        }


     User user=   userRepository.findById(UserId).get();
        //setting above ratings arraylist in rating attribute of User
        user.setRatings(ratings1);

        return user;
    }

    @Override
    public String deleteUser(String UserId) {
        userRepository.deleteById(UserId);
        return "User with id "+UserId+" deleted";
    }

    @Override
    public User updateUser(String UserId) {
        return null;
    }
}
