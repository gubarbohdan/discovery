package com.bohdan.hubar.discovery.hotel;

import com.bohdan.hubar.discovery.reservation.Reservation;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(MinimalView.class)
    private Long id;

    @NotEmpty
    @JsonView(MinimalView.class)
    private String name;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonView(WithReservationsView.class)
    private Collection<Reservation> reservations;

    public interface MinimalView {}

    public interface WithReservationsView extends MinimalView, Reservation.WithTripsView {}

}
