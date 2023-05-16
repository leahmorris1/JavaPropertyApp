package com.example.estateagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@Entity
@Table (name = "sellers")
public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seller_id;
    @Column (name = "firstName")
    private String firstName;
    private String surname;
    private String address;
    private String postcode;
    private String phone;

    public Sellers(int seller_id, String firstName, String surname, String address, String postcode, String phone) {
        this.seller_id = seller_id;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
    }

    public Sellers() {

    }

    //get and set seller_id
    public long getSeller_id() {
        return seller_id;
    }
    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    //get and set firstname
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //get and set email;
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

    //get and set list
    //public List<Properties> getPropertiesList() {
     //   return propertiesList;
    //}
    //public void setPropertiesList(List<Properties> propertiesList) {
     //   this.propertiesList = propertiesList;
    //}


    //@OneToMany(mappedBy = "sellers", fetch = FetchType.EAGER)
    //@JsonIgnore
    //private List<Properties> propertiesList;

    @Override
    public String toString() {
        return "Sellers{" +
                "seller_id=" + seller_id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
