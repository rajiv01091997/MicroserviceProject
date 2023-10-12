package com.globallogic.Service;

import com.globallogic.Entity.Rating;
import com.globallogic.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceImpl implements RatingService{
    @Autowired
    private RatingRepository repository;
    @Override
    public Rating createRating(Rating rating) {
        String id= UUID.randomUUID().toString();
        rating.setRatingId(id);
        return repository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUserId(String id) {
        return repository.findAllByUserId(id);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String id) {
        return repository.findAllByHotelId(id);
    }
}
