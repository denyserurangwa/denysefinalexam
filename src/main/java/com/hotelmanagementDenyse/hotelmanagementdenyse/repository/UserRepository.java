package com.hotelmanagementDenyse.hotelmanagementdenyse.repository;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from User  where email=:username and password=:password")
    User login(String username, String password);
}
