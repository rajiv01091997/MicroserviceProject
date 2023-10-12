package com.globallogic.Controller;

import com.globallogic.Entity.Rating;
import com.globallogic.Service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private ServiceImpl service;
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return new ResponseEntity<>(service.createRating(rating), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating()
    {
        return new ResponseEntity<>(service.getAllRating(),HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String id)
    {
        return new ResponseEntity<>(service.getAllRatingByUserId(id),HttpStatus.OK);
    }
    @GetMapping("/hotels/{id}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String id)
    {
        return new ResponseEntity<>(service.getAllRatingByHotelId(id),HttpStatus.OK);
    }


}
