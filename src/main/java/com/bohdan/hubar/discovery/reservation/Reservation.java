package com.bohdan.hubar.discovery.reservation;

import com.bohdan.hubar.discovery.hotel.Hotel;
import com.bohdan.hubar.discovery.trip.Trip;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(MinimalView.class)
    private Long id;

    @JsonView(MinimalView.class)
    private Date fromDate;

    @JsonView(MinimalView.class)
    private Date toDate;

    @ManyToOne
    @JsonView(WithHotelsView.class)
    private Hotel hotel;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonView(WithTripsView.class)
    private Trip trip;

    public interface MinimalView {}

    public interface WithHotelsView extends MinimalView, Hotel.MinimalView {}

    public interface WithTripsView extends MinimalView, Trip.WithClientsView {}

}
