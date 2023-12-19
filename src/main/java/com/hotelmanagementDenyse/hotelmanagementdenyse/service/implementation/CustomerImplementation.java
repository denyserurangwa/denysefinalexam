package com.hotelmanagementDenyse.hotelmanagementdenyse.service.implementation;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Customer;
import com.hotelmanagementDenyse.hotelmanagementdenyse.model.CustomerReservation;
import com.hotelmanagementDenyse.hotelmanagementdenyse.repository.CustomerDao;
import com.hotelmanagementDenyse.hotelmanagementdenyse.repository.CustomerResrvationDao;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.CustomerReservationService;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.CustomerService;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerImplementation implements CustomerReservationService {
    @Autowired
    private CustomerResrvationDao dao;
    @Autowired
    private EmailService emailService;


    @Override
    public CustomerReservation createResrvation(CustomerReservation customerReservation) {
        return dao.save(customerReservation);
    }

    @Override
    public List<CustomerReservation> getAllReservations() {
        return dao.findAll();
    }

    @Override
    public List<CustomerReservation> findByCustomerId(Integer customerId) {
        return dao.findByCustomer(customerId);
    }
}
