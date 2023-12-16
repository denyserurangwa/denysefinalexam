package com.hotelmanagementDenyse.hotelmanagementdenyse.service.implementation;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Room;
import com.hotelmanagementDenyse.hotelmanagementdenyse.repository.RoomRepository;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomImplementation implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room findRoomById(Integer roomId) {
        return roomRepository.findById(roomId).get();
    }

    @Override
    public Room newRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Integer roomId) {
        if (roomRepository.existsById(roomId)) {
            roomRepository.deleteById(roomId);
        }

    }

    @Override
    public Room update(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getRoomList() {
        return roomRepository.findAll();
    }
}
