package com.amal.reservation;

import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.amal.reservation.entities.Reservation;
import com.amal.reservation.repos.ReservationRepository;
import com.amal.reservation.service.ReservationService;

@SpringBootTest
class ReservationS2ApplicationTests {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ReservationService reservationService;

	@Test
	public void testCreateReservation() {
		Reservation res = new Reservation("amal bouaouina", 2200.500, new Date());
		reservationRepository.save(res);
	}

	/*
	 * @Test public void testFindReservation() { Reservation r =
	 * reservationRepository.findById(1L).get(); System.out.println(r); }
	 */

	/*
	 * @Test public void testUpdateReservation() { Reservation r =
	 * reservationRepository.findById(1L).get(); r.setPrixSejour(1000.0);
	 * reservationRepository.save(r); }
	 */

	@Test
	public void testDeleteReservation() {
		reservationRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousReservations() {
		List<Reservation> res = reservationRepository.findAll();
		for (Reservation r : res) {
			System.out.println(r);
		}
	}
	 @Test
	 public void testFindByNomReservationContains()
	 {
	 Page<Reservation> res =reservationService.getAllReservationsParPage(0,2);
	 System.out.println(res.getSize());
	 System.out.println(res.getTotalElements());
	 System.out.println(res.getTotalPages());
	 res.getContent().forEach(p -> {System.out.println(p.toString());
	  });
	 /*ou bien
	 for (Produit p : prods)
	 {
	 System.out.println(p);
	 } */
	 }


}
