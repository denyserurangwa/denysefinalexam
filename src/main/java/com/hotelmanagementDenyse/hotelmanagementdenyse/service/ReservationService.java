package com.hotelmanagementDenyse.hotelmanagementdenyse.service;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation findReservationById(Integer resId);
    Reservation newreservation(Reservation reservation);
    void deleteReservation(Integer resId );
    Reservation updateReservation(Reservation reservation);
    List<Reservation> getReservation();

}
