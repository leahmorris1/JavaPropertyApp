package com.example.estateagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;

    private String email;

    private String address;

    private int postcode;

    private int phone;

    @ManyToOne
    private Buyers buyers;

    @OneToMany(mappedBy = "sellers", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Properties> propertiesList;

    public long getId() {
        return id;
    }

    public Sellers(long id, String firstName, String lastName, String email, String address, int postcode, int phone, Buyers buyers, List<Properties> propertiesList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
        this.buyers = buyers;
        this.propertiesList = propertiesList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Buyers getBuyers() {
        return buyers;
    }

    public void setBuyers(Buyers buyers) {
        this.buyers = buyers;
    }

    public List<Properties> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(List<Properties> propertiesList) {
        this.propertiesList = propertiesList;
    }

    public Sellers() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public List<Properties> getAddressList() {
        return propertiesList;
    }

    public void setAddressList(List<Properties> propertiesList) {
        this.propertiesList = propertiesList;
    }

    @Override
    public String toString() {
        return "Sellers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", postcode=" + postcode +
                ", phone=" + phone +
                ", buyers=" + buyers +
                ", propertiesList=" + propertiesList +
                '}';
    }
}
