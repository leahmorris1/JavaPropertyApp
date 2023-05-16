package com.example.estateagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@Entity
@Table (name= "buyers")
public class Buyers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long buyer_id;
    @Column (name = "firstName")
    private String firstName;
    private String surname;
    private String address;
    private String postcode;
    private String phone;

    //constructor
    public Buyers(long buyer_id, String firstName, String surname, String address, String postcode, String phone) {
        this.buyer_id = buyer_id;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
    }
    public Buyers() {
    }

    //get and set id
    public long getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(long buyer_id) {
        this.buyer_id = buyer_id;
    }

    //get and set firstname
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //get and set surname
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //get and set address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    //get and set postcode
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    //get and set phone
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Buyers{" +
                "buyer_id=" + buyer_id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
