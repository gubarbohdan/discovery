package com.bohdan.hubar.discovery.client;

import com.bohdan.hubar.discovery.trip.Trip;
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
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Provide a valid email")
    private String email;

    private String phone;

    @ManyToMany(mappedBy = "clients")
    private Collection<Trip> trips;
}
