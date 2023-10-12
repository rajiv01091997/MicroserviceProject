package com.globallogic.Service;

import com.globallogic.Entity.Rating;

import java.util.List;

public interface RatingService {

    public Rating createRating(Rating rating);
    public List<Rating> getAllRating();

    public List<Rating> getAllRatingByUserId(String id);
    public List<Rating> getAllRatingByHotelId(String id);
}
