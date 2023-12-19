package com.hotelmanagementDenyse.hotelmanagementdenyse.repository;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationR extends JpaRepository<Reservation,Integer> {

    @Query("SELECT r FROM Reservation r WHERE LOWER(r.names) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(r.reservationId) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Reservation> searchReservationsByKeyword(@Param("keyword") String keyword);

}
