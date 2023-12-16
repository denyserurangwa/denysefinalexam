package com.hotelmanagementDenyse.hotelmanagementdenyse.service;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room findRoomById(Integer roomId);
    Room newRoom(Room room);
    void deleteRoom(Integer roomId);
    Room update(Room room);
    List<Room> getRoomList();
}
