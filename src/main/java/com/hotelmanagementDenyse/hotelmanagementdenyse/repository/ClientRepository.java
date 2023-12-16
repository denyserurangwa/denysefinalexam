package com.hotelmanagementDenyse.hotelmanagementdenyse.repository;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {//not implementable
}
