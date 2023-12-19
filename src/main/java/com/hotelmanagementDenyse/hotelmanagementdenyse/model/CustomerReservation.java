package com.hotelmanagementDenyse.hotelmanagementdenyse.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity

public class CustomerReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resId;
    private String reservationId;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String email;
    private String names;
    private Integer adult;
    private Integer child;
    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;
    @JoinColumn(name="room_id")
    @ManyToOne
    private Room room;
}
