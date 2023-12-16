package com.hotelmanagementDenyse.hotelmanagementdenyse.controller;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Room;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/room")
    public String allRoom(Model model) {
        Room room = new Room();
        List<Room> roomList = roomService.getRoomList();
        model.addAttribute("room",room);
        model.addAttribute("roomList",roomList);
        return "room";
    }

    @PostMapping("/room/new")
    public String newRoom(Room room, Model model) {
        Room room1 = roomService.newRoom(room);
        return "redirect:/room";
    }


    @GetMapping("/deleteRoom/{roomId}")
    public String deleteRoom(@PathVariable Integer roomId, Model model) {
        try {
            roomService.deleteRoom(roomId);
        } catch (DataIntegrityViolationException e) {
            // Handle the exception when a foreign key constraint fails
            model.addAttribute("error", "Cannot delete room with reservations. Please delete reservations first.");
            return "errorPage"; // You can create a custom error page or redirect to another page
        }

        return "redirect:/room";
    }


    //trigger in plsql :)

    @GetMapping("/editRoom/{roomId}")
    public String editRoomPage(@PathVariable Integer roomId, Model model) {
        // Retrieve room information by roomId and add it to the model
        Room room = roomService.findRoomById(roomId);
        model.addAttribute("room", room);
        return "editRoom";
    }









}
