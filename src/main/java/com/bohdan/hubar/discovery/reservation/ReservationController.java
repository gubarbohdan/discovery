package com.bohdan.hubar.discovery.reservation;

import org.springframework.stereotype.Controller;

@Controller
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
}
