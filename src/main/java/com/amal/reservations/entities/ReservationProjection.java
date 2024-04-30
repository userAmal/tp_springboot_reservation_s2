package com.amal.reservations.entities;
import org.springframework.data.rest.core.config.Projection;

import com.amal.reservation.entities.Reservation;
@Projection(name = "nomCli", types = { Reservation.class })

public interface ReservationProjection {

	public String getNomClient();
}
