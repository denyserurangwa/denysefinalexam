package com.hotelmanagementDenyse.hotelmanagementdenyse.controller;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.*;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.CustomerReservationService;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.ReservationService;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.RoomService;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
public class PageControler {
//    @GetMapping("/editRoom")
//    public String getAbout(){
//        return "editRoom";
//    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }
    @GetMapping("/accomodation")
    public String getAccomodation(){
        return "accomodation";
    }
    @GetMapping("/elements")
    public String getElements(){
        return "elements";
    }
    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }
    @GetMapping("/gallery")
    public String getGallery(){
        return "gallery";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session
        session.invalidate();

        // Redirect to the root URL
        return "redirect:/login";
    }
    @RequestMapping("/logout1")
    public String logout1(HttpSession session) {
        // Invalidate the session
        session.invalidate();

        // Redirect to the root URL
        return "redirect:/cutomerLogin";
    }
    @Autowired
    private UserService userService;

    @PostMapping("/loginAdmin")
    public String LoginAdmin(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        User user=userService.login(email, password);
        if(user==null){
            model.addAttribute("error","Incorrect Username and Password");
            return "redirect:/login";
        }else{
            session.setAttribute("adminAuthenticated",user);
            return "redirect:/room";
        }

    }
    @GetMapping("/cutomerLogin")
    public String getCustomerLogin(Model model){

        return "clientLogin";
    }
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private RoomService roomService;
    @GetMapping("/reservationCustomer")
    public String getCustomerReservation(Model model,HttpSession session){

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

        return "clientReservation";
    }

    @GetMapping("/myReservation")
    public String getMyResevation(Model model){

        return "clientAllReservations";
    }
    @GetMapping("/registration")
    public String getRegistrattion(Model model){
        model.addAttribute("customer",new Customer());
        return "registration";
    }

}
