package com.hotelmanagementDenyse.hotelmanagementdenyse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="reservation")
public class Reservation {
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
    @JoinColumn(name="cId")
    private Client client;
    @ManyToOne
    @JoinColumn( name = "roomId")
    private Room room;

}
