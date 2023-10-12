package com.globallogic.Service;

import com.globallogic.Entity.Hotel;
import com.globallogic.Repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceImpl implements HotelService{
    @Autowired
    private HotelRepository repository;
    @Override
    public Hotel createHotel(Hotel hotel) {
       String id= UUID.randomUUID().toString();
       hotel.setId(id);
        return repository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return repository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return repository.findById(id).get();
    }
}
