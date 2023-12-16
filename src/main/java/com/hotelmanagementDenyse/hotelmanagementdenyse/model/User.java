package com.hotelmanagementDenyse.hotelmanagementdenyse.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="user",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name="user_roles",
            joinColumns = @JoinColumn(
                    name="user_id",referencedColumnName = "id"),//fk from user
            inverseJoinColumns =@JoinColumn(
                    name = "role_id",referencedColumnName = "id"))//fk from role
    private Collection <Role> roles;

    public User() {
    }


    public User(Long id, String fname, String lname, String email, String password, Collection<Role> roles) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public <T> User(String fname, String lname, String email, String passwword, List<T> roleUser) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
