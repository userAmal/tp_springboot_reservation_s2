package com.amal.reservation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.amal.reservation.service.ReservationService;
import com.amal.reservation.entities.Reservation;

@SpringBootApplication
public class ReservationS2Application implements CommandLineRunner{
	@Autowired
	ReservationService reservationService;
	
	public static void main(String[] args) {
		SpringApplication.run(ReservationS2Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		reservationService.saveReservation(new Reservation("syrine boussetta", 2600.0, new Date()));
		reservationService.saveReservation(new Reservation("soumaya aniba", 2800.0, new Date()));
		reservationService.saveReservation(new Reservation("ranim jrad", 900.0, new Date()));
	}
//	--------
	 
	 //------




}
