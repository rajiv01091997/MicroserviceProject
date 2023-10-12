package com.globallogic.Controller;

import com.globallogic.Entity.Hotel;
import com.globallogic.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService service;
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        return new ResponseEntity<>(service.createHotel(hotel), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
        return new ResponseEntity<>(service.getAllHotels(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable  String id)
        {
            return new ResponseEntity<>(service.getHotelById(id),HttpStatus.OK);
        }

}
