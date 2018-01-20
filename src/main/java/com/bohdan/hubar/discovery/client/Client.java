package com.bohdan.hubar.discovery.client;

import com.bohdan.hubar.discovery.trip.Trip;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(MinimalView.class)
    private Long id;

    @Column(name = "first_name")
    @JsonView(MinimalView.class)
    private String firstName;

    @Column(name = "last_name")
    @JsonView(MinimalView.class)
    private String lastName;

    @Email(message = "Provide a valid email")
    @JsonView(MinimalView.class)
    private String email;

    @JsonView(MinimalView.class)
    private String phone;

    @ManyToMany(mappedBy = "clients")
    @JsonView(WithTripsView.class)
    private Collection<Trip> trips;

    public interface MinimalView {}

    public interface WithTripsView extends MinimalView, Trip.MinimalView {}
}
