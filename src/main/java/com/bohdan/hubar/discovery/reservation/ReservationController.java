package com.bohdan.hubar.discovery.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/reservations/client/{clientId}")
    public List<Reservation> getClientsReservationByClientId(@PathVariable Long clientId) {
        return reservationService.findReservationsByClientId(clientId);
    }
}
