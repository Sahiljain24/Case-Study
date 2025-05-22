package com.online.reservation.controller;




import com.online.reservation.dto.ReservationRequestDTO;
import com.online.reservation.model.Reservation;
import com.online.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/book")
    public ResponseEntity<Reservation> book(@RequestBody ReservationRequestDTO dto) {
        return ResponseEntity.ok(reservationService.createReservation(dto));
    }

    @PutMapping("/cancel/{pnr}")
    public ResponseEntity<String> cancel(@PathVariable String pnr) {
        Reservation res = reservationService.cancelReservation(pnr);
        return ResponseEntity.ok("Your reservation with PNR " + pnr + " has been cancelled.");
    }
}

