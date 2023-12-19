package com.hotelmanagementDenyse.hotelmanagementdenyse.service;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Customer;
import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Reservation;

public interface EmailService {
    void sendEmail(Reservation reservation);
}
