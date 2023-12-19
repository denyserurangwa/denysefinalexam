package com.hotelmanagementDenyse.hotelmanagementdenyse.service;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Customer;

public interface CustomerService {
    Customer createAccount(Customer customer);
    Customer login(String email, String password);
    Customer findById(Integer customerId);

    Customer newCustomer(Customer customer);
}
