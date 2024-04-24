package com.amal.reservation.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amal.reservation.entities.Reservation;
import com.amal.reservation.service.ReservationService;
@Controller
public class ReservationController {
	@Autowired
	ReservationService reservationService;
	 @RequestMapping("/listeReservations")
	public String listeReservations(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page, @RequestParam (name="size", defaultValue = "4") int size)
	{
		 {
			 Page<Reservation> res = reservationService.getAllReservationsParPage(page, size);
			 modelMap.addAttribute("reservations", res);
			  modelMap.addAttribute("pages", new int[res.getTotalPages()]);
			 modelMap.addAttribute("currentPage", page);
			 modelMap.addAttribute("size", size);
			 return "listeReservations.html";
			 }
	}
	 @RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createReservation";
	}
	@RequestMapping("/saveReservation")
	public String saveReservation(@ModelAttribute("reservation") Reservation reservation, 
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateReservation = dateformat.parse(String.valueOf(date));
	 reservation.setDateReservation(dateReservation);
	 
	 Reservation saveReservation = reservationService.saveReservation(reservation);
	String msg ="produit enregistré avec Id "+saveReservation.getIdReservation();
	modelMap.addAttribute("msg", msg);
	return "createProduit";
	}
	@RequestMapping("/supprimerReservation")
	public String supprimerReservation(@RequestParam("id") Long id,
	 ModelMap modelMap,
	 @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{ 
	reservationService.deleteReservationById(id);
	Page<Reservation> res = reservationService.getAllReservationsParPage(page, size);
			modelMap.addAttribute("reservations", res);
			modelMap.addAttribute("pages", new int[res.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeReservations";

	}
	 
	 @RequestMapping("/modifierReservation")
	public String editerReservation(@RequestParam("id") Long id,
	 ModelMap modelMap)
	{
	Reservation r= reservationService.getReservation(id);
	modelMap.addAttribute("reservation", r);
	return "editerReservation";
	}
	@RequestMapping("/updateReservation")
	public String updateReservation(@ModelAttribute("reservation") Reservation reservation, @RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateReservation= dateformat.parse(String.valueOf(date));
	 reservation.setDateReservation(dateReservation);
	 
	 reservationService.updateReservation(reservation);
	 List<Reservation> res = reservationService.getAllReservations();
	 modelMap.addAttribute("Reservations", res);
	return "listeReservations";
	}


}
