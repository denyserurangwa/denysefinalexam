package com.hotelmanagementDenyse.hotelmanagementdenyse.controller;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Client;
import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Reservation;
import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Room;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.ClientService;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.ReservationService;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/client")
    public String allClient(Model model){
        Client client = new Client();
        List<Client> clientList=clientService.getClient();
        model.addAttribute("client",client);
        model.addAttribute("clientList",clientList);

        return "client";
    }

    @PostMapping("/client/new")
    public String newClient(Client client, Model model){
        Client client1 =clientService.client(client);
        return "redirect:/client";
    }

    @GetMapping("/deleteClient/{cId}")
    public String deleteClient(@PathVariable Integer cId, Model model) {
        clientService.deleteClient(cId);
        return "redirect:/client";
    }


    @GetMapping("/editClient/{cId}")
    public String editClientPage(@PathVariable Integer cId, Model model) {
        // Retrieve client information by cId and add it to the model
        Client client = clientService.findClientById(cId);
        model.addAttribute("client", client);
        return "client";
    }

}
