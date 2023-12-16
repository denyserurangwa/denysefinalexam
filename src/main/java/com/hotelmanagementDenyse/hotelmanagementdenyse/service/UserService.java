package com.hotelmanagementDenyse.hotelmanagementdenyse.service;

import com.hotelmanagementDenyse.hotelmanagementdenyse.dto.UserRegistrationDto;
import com.hotelmanagementDenyse.hotelmanagementdenyse.model.User;

public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);
    User login(String email, String password);


}
