package com.hotelmanagementDenyse.hotelmanagementdenyse.repository;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.CustomerReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerResrvationDao extends JpaRepository<CustomerReservation,Integer> {
    @Query("from CustomerReservation where customer.customerId=:customerId")
    List<CustomerReservation> findByCustomer(Integer customerId);
}
