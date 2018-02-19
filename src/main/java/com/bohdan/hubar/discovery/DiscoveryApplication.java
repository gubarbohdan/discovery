package com.bohdan.hubar.discovery;

import com.bohdan.hubar.discovery.client.Client;
import com.bohdan.hubar.discovery.client.ClientService;
import com.bohdan.hubar.discovery.hotel.Hotel;
import com.bohdan.hubar.discovery.hotel.HotelService;
import com.bohdan.hubar.discovery.reservation.Reservation;
import com.bohdan.hubar.discovery.reservation.ReservationService;
import com.bohdan.hubar.discovery.trip.Trip;
import com.bohdan.hubar.discovery.trip.TripService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryApplication.class, args);
	}

	@Transactional
	@Bean
	CommandLineRunner runner(ClientService clientService,
                             HotelService hotelService,
                             TripService tripService,
                             ReservationService reservationService){
		return args -> {
            System.out.println("CommandLineRunner running in the DiscoveryApplication class...");


            Hotel hotel = new Hotel();
            hotel.setName("Citymax hotel Albarsha");
            hotelService.saveHotel(hotel);

            Reservation reservation = new Reservation();
            reservation.setFromDate(new Date());
            reservation.setToDate(new Date());
            reservation.setHotel(hotel);
            reservationService.save(reservation);

            List<Reservation> reservationList = new ArrayList<>();
            reservationList.add(reservation);

            Trip trip = new Trip();
            trip.setFromDate(new Date());
            trip.setToDate(new Date());
            trip.setReservations(reservationList);
            trip.setPrice(900.);
//            trip = tripService.createTrip(trip);

            List<Trip> tripList = new ArrayList<>();
            tripList.add(trip);

            Client client = new Client();
            client.setFirstName("Bohdan");
            client.setLastName("Hubar");
            client.setEmail("gubarbohdan@gmail.com");
            client.setPhone("+380936612126");
            client.setTrips(tripList);
            clientService.createClient(client);


        };
	}
}
