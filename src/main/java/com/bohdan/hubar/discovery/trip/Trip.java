package com.bohdan.hubar.discovery.trip;

import com.bohdan.hubar.discovery.client.Client;
import com.bohdan.hubar.discovery.reservation.Reservation;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(MinimalView.class)
    private Long id;

    @JsonView(MinimalView.class)
    private Date fromDate;

    @JsonView(MinimalView.class)
    private Date toDate;

    @JsonView(MinimalView.class)
    private Double price;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonView(WithReservationsView.class)
    private Collection<Reservation> reservations;

    @ManyToMany
    @JoinTable(name = "clients_trips")
    @JsonView(WithClientsView.class)
    private Collection<Client> clients;

    public interface MinimalView {}

    public interface WithReservationsView extends MinimalView {}

    public interface WithClientsView extends MinimalView {}

}
