package com.hotelmanagementDenyse.hotelmanagementdenyse.dto;

import com.hotelmanagementDenyse.hotelmanagementdenyse.model.Role;

import java.util.Collection;

public class UserRegistrationDto {
    private String fname;
    private String lname;
    private String email;
    private String passwword;
//    private Collection<Role> roles;


    public UserRegistrationDto(String fname, String lname, String email, String passwword) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.passwword = passwword;
    }

    public UserRegistrationDto() {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswword() {
        return passwword;
    }

    public void setPasswword(String passwword) {
        this.passwword = passwword;
    }
}
