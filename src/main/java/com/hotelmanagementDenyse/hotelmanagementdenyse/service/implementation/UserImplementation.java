package com.hotelmanagementDenyse.hotelmanagementdenyse.service.implementation;

import com.hotelmanagementDenyse.hotelmanagementdenyse.dto.UserRegistrationDto;
import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Role;
import com.hotelmanagementDenyse.hotelmanagementdenyse.model.User;
import com.hotelmanagementDenyse.hotelmanagementdenyse.repository.UserRepository;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserImplementation implements UserService {

    private UserRepository userRepository;

    public UserImplementation(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User(userRegistrationDto.getFname(),
                userRegistrationDto.getLname(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPasswword(), Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);

    }

    @Override
    public User login(String email, String password) {
        return userRepository.login(email, password);
    }
}
