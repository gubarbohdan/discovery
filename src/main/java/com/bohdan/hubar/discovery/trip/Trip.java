package com.bohdan.hubar.discovery.trip;

import com.bohdan.hubar.discovery.client.Client;
import com.bohdan.hubar.discovery.reservation.Reservation;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Data
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate fromDate;

    private LocalDate toDate;

    private Double price;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Reservation> trips;

    @ManyToMany
    @JoinTable(name = "clients_trips")
    private Collection<Client> clients;
}
