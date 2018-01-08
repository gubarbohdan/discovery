package com.bohdan.hubar.discovery.reservation;

import com.bohdan.hubar.discovery.client.Client;
import com.bohdan.hubar.discovery.client.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private ClientService clientService;

    public ReservationService(ReservationRepository reservationRepository, ClientService clientService) {
        this.reservationRepository = reservationRepository;
        this.clientService = clientService;
    }

    public List<Reservation> findReservationsByClientId(Long clientId) {
        Client client = clientService.findById(clientId);

        return client.getTrips().stream()
                .flatMap(x -> x.getReservations().stream())
                .collect(Collectors.toList());
    }
}
