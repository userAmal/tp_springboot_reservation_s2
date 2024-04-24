package com.amal.reservation.entities;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReservation;
	private String nomClient;
	private Double prixSejour;
	private Date dateReservation;
	
	public Reservation(String nomClient, Double prixSejour, Date dateReservation) {
		super();
		this.nomClient = nomClient;
		this.prixSejour = prixSejour;
		this.dateReservation = dateReservation;
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Double getPrixSejour() {
		return prixSejour;
	}
	public void setPrixSejour(Double prixSejour) {
		this.prixSejour = prixSejour;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", nomClient=" + nomClient + ", prixSejour=" + prixSejour
				+ ", dateReservation=" + dateReservation + "]";
	}
	




}
