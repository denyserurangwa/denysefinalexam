package com.hotelmanagementDenyse.hotelmanagementdenyse.service.implementation;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Customer;
import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Reservation;
import com.hotelmanagementDenyse.hotelmanagementdenyse.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImplementation implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
//    @Override
//    public void sendEmail(Customer customer) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(customer.getEmail());
//        message.setSubject("reservation of room");
//        message.setText("Hello Dear Customer"+" "+customer.getNames()+" with phone number "+customer.getPhone()+" welcome to our online room reservation ");
//        javaMailSender.send(message);
//    }

    @Override
    public void sendEmail(Reservation reservation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(reservation.getEmail());
        message.setSubject("reservation of room");
        message.setText("Hello Dear Customer"+" "+reservation.getNames()+" with phone number "+reservation.getEmail()+" welcome to our online room reservation ");
        javaMailSender.send(message);

    }
}
