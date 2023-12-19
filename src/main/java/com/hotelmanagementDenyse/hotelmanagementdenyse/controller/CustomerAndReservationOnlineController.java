package com.hotelmanagementDenyse.hotelmanagementdenyse.controller;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Customer;
import com.hotelmanagementDenyse.hotelmanagementdenyse.model.CustomerReservation;
import com.hotelmanagementDenyse.hotelmanagementdenyse.model.User;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerAndReservationOnlineController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/loginClient")
    public String LoginAdmin(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        Customer user=customerService.login(email, password);
        if(user==null){
            model.addAttribute("error","Incorrect Username and Password");
            return "redirect:/cutomerLogin";
        }else{
            session.setAttribute("logedInCustomer",user);
            return "redirect:/reservationCustomer";
        }

    }
    @PostMapping("/newCustomer")
    public String newCustomer(Customer customer){
        customerService.createAccount(customer);
        return "redirect:/cutomerLogin";
    }

}
