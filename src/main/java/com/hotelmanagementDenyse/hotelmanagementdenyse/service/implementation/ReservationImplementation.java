package com.hotelmanagementDenyse.hotelmanagementdenyse.service.implementation;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Reservation;
import com.hotelmanagementDenyse.hotelmanagementdenyse.repository.ReservationR;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationImplementation implements ReservationService {
   @Autowired
   private ReservationR reservationR;

    @Override
    public Reservation findReservationById(Integer resId) {
        return reservationR.findById(resId).get();
    }

    @Override
    public Reservation newreservation(Reservation reservation) {

        return reservationR.save(reservation);
    }

    @Override
    public void deleteReservation(Integer resId) {
        if(reservationR.existsById(resId)){
            reservationR.deleteById(resId);
        }
    }


    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationR.save(reservation);
    }

    @Override
    public List<Reservation> getReservation() {

        return reservationR.findAll();
    }
}
