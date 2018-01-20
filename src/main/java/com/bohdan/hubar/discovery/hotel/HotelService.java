package com.bohdan.hubar.discovery.hotel;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findOne(hotelId);
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
