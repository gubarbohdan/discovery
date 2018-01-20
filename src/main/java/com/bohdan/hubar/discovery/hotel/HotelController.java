package com.bohdan.hubar.discovery.hotel;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(value = "hotels")
    @JsonView(Hotel.MinimalView.class)
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping(value = "hotels/{hotelId}")
    @JsonView(Hotel.MinimalView.class)
    public Hotel getHotelById(@PathVariable Long hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    @PostMapping(value = "hotels")
    @JsonView(Hotel.MinimalView.class)
    public Hotel createHotel(Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }
}
