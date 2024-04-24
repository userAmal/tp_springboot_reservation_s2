package com.amal.reservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amal.reservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
