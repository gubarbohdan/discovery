package com.bohdan.hubar.discovery.reservation;

import com.bohdan.hubar.discovery.hotel.Hotel;
import com.bohdan.hubar.discovery.trip.Trip;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate fromDate;

    private LocalDate toDate;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Trip trip;

}
