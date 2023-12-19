package com.hotelmanagementDenyse.hotelmanagementdenyse.repository;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDao extends JpaRepository<Customer,Integer> {
    @Query("from Customer where email=:email and password=:password")
    Customer login(String email, String password);
}
