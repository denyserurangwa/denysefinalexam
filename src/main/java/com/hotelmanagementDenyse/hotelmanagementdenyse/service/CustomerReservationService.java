package com.hotelmanagementDenyse.hotelmanagementdenyse.service;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.CustomerReservation;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.implementation.CustomerImplementation;

import java.util.List;

public interface CustomerReservationService {
    CustomerReservation createResrvation(CustomerReservation customerReservation);
    List<CustomerReservation> getAllReservations();
    List<CustomerReservation> findByCustomerId(Integer customerId);
}
