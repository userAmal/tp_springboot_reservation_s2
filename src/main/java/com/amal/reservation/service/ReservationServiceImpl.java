package com.amal.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.amal.reservation.entities.Reservation;
import com.amal.reservation.repos.ReservationRepository;
@Service

public class ReservationServiceImpl  implements ReservationService{
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation saveReservation(Reservation p) {
		return reservationRepository.save(p);		
	}

	@Override
	public Reservation updateReservation(Reservation p) {
		return reservationRepository.save(p);
	}

	@Override
	public void deleteReservation(Reservation p) {
		reservationRepository.delete(p);
		
	}

	@Override
	public void deleteReservationById(Long id) {
		reservationRepository.deleteById(id);
		
	}

	@Override
	public Reservation getReservation(Long id) {
		return reservationRepository.findById(id).get();

	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();

	}
	@Override
	public Page<Reservation> getAllReservationsParPage(int page, int size) {
	return reservationRepository.findAll(PageRequest.of(page, size));
	}

}
