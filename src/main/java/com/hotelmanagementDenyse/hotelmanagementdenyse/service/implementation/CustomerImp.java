package com.hotelmanagementDenyse.hotelmanagementdenyse.service.implementation;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Customer;
import com.hotelmanagementDenyse.hotelmanagementdenyse.repository.CustomerDao;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.CustomerService;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerImp implements CustomerService {
    @Autowired
    private CustomerDao dao;
    @Autowired
    private EmailService emailService;
    @Override
    public Customer createAccount(Customer customer) {
        return dao.save(customer);
    }

    @Override
    public Customer login(String email, String password) {
        return dao.login(email, password);
    }

    @Override
    public Customer findById(Integer customerId) {
        return dao.findById(customerId).get();
    }

    @Override
    public Customer newCustomer(Customer customer) {
        return null;
    }

//    @Override
//    public Customer newCustomer(Customer customer) {
//        Customer customer1=dao.save(customer);
//        if(customer1!=null) {
//            emailService.sendEmail(customer);
//            return customer1;
//        }else {return null;}
//    }
}
