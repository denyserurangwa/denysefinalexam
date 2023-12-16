package com.hotelmanagementDenyse.hotelmanagementdenyse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    private String roomNumber;
    private String floorNumber;
    private String type;
    private String status;
    private Float price;
    private String roomDescription;
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

}
