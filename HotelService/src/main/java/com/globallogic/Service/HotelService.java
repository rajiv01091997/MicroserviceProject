package com.globallogic.Service;

import com.globallogic.Entity.Hotel;

import java.util.*;

public interface HotelService {

    //create Hotel

    public Hotel createHotel(Hotel hotel);

    //getall

    public List<Hotel> getAllHotels();


    //get single
    public Hotel getHotelById(String id);
}
