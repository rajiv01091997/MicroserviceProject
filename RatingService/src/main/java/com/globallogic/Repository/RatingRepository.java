package com.globallogic.Repository;

import com.globallogic.Entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {

    public List<Rating> findAllByUserId(String userId);

   public List<Rating> findAllByHotelId(String hotelId);
}
