package com.hotelmanagementDenyse.hotelmanagementdenyse.controller;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Reservation;
import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Room;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.ReservationService;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Random;

@Controller
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private RoomService roomService;

    @GetMapping("/reservation")
    public String allReservatioin(Model model){
        Reservation reservation = new Reservation();
        List<Reservation> reservationList = reservationService.getReservation();

        int min = 1000; // Define your minimum registration number
        int max = 9999; // Define your
        // maximum registration number
        int randomReservationNumber = new Random().nextInt(max - min + 1) + min;

        model.addAttribute("randomReservationNumber",randomReservationNumber);
        model.addAttribute("reservation", reservation);
        model.addAttribute("reservationList", reservationList);

        Room room = new Room();
        List<Room> roomList = roomService.getRoomList();
        model.addAttribute("room",room);
        model.addAttribute("roomList",roomList);

        return "reservation";
    }

    @PostMapping("/reservation/new")
    public String newreservation(Reservation reservation, Model model) {
        Reservation reservation1=reservationService.newreservation(reservation);
        return "redirect:/reservation";
    }

    @GetMapping("/deleteReservation/{resId}")
    public String deleteEvent(@PathVariable Integer resId, Model model) {
        try {
            reservationService.deleteReservation(resId);
        } catch (Exception e) {
            // Handle the exception, you can log it or perform other actions as needed
            e.printStackTrace(); // Print the stack trace for debugging purposes
            // You might want to add an error message to the model to display it in the view
            model.addAttribute("error", "An error occurred while deleting the reservation.");
        }
        return "redirect:/reservation";
    }


    @GetMapping("/editReservation/{resId}")
    public String editReservationPage(@PathVariable Integer resId, Model model) {
        Reservation reservation =reservationService.findReservationById(resId);
        model.addAttribute("reservation",reservation);
        return "editReservation";
    }




}
