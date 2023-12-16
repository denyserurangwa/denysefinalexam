package com.hotelmanagementDenyse.hotelmanagementdenyse.repository;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationR extends JpaRepository<Reservation,Integer> {
}
