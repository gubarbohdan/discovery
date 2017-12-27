package com.bohdan.hubar.discovery.hotel;

import com.bohdan.hubar.discovery.reservation.Reservation;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private Collection<Reservation> reservations;

}
