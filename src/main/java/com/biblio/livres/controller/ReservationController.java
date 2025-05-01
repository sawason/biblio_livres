package com.biblio.livres.controller;


import com.biblio.livres.model.Reservation;
import com.biblio.livres.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    // GET /reservations/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return reservationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @GetMapping
    public Iterable<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

//    @PostMapping
//    public Reservation createReservation(@RequestBody Reservation reservation) {
//        return reservationRepository.save(reservation);
//    }
//

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        if (reservation.getDateReservation() == null) {
            reservation.setDateReservation(LocalDate.now());
        }

        reservation.setDateFinReservation(reservation.getDateReservation().plusDays(15));

        return reservationRepository.save(reservation);
    }




}



