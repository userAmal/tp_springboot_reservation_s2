package com.amal.reservation.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.amal.reservation.entities.Reservation;

public interface ReservationService {
	Reservation saveReservation(Reservation p);
	Reservation updateReservation(Reservation p);
	void deleteReservation(Reservation p);
	 void deleteReservationById(Long id);
	 Reservation getReservation(Long id);
	List<Reservation> getAllReservations();
	Page<Reservation> getAllReservationsParPage(int page, int size);
}
