package com.bohdan.hubar.discovery.trip;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping(value = "/trips")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping(value = "/trip/{id}")
    public Trip getTripById(@PathVariable("id") Long id) {
        return tripService.getTripById(id);
    }

    @PostMapping(value = "/trips")
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }
}
