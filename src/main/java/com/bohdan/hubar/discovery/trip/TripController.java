package com.bohdan.hubar.discovery.trip;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

    private TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping(value = "/trips")
    @JsonView(Trip.MinimalView.class)
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping(value = "/trip/{id}")
    @JsonView(Trip.MinimalView.class)
    public Trip getTripById(@PathVariable("id") Long id) {
        return tripService.getTripById(id);
    }

    @PostMapping(value = "/trips")
    @JsonView(Trip.MinimalView.class)
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.createTrip(trip);
    }
}
