package com.example.estateagency.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Entity
@Table(name = "properties")
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int property_id;
    private String address;
    private String postcode;
    private String type;
    private int bedrooms;
    private int bathrooms;
    private boolean garden;
    private int price;
    private String status;

    @JoinColumn(name = "seller_id")
    @ManyToOne
    private Sellers seller;

    public Sellers getSeller() {
        return seller;
    }

    public void setSeller(Sellers seller) {
        this.seller = seller;
    }

    //constructor
    public Properties(int property_id, String address, String postcode, String type, int bedrooms, int bathrooms, boolean garden, int price, String status, Sellers seller) {
        this.property_id = property_id;
        this.address = address;
        this.postcode = postcode;
        this.type = type;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.garden = garden;
        this.price = price;
        this.status = status;
        this.seller = seller;
    }

    //get and set property_id
    public int getProperty_id() {
        return property_id;
    }
    public void setProperty_id(int property_id) {
        this.property_id = property_id;
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

    //get and set type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //get and set bedrooms
    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    //get and set bathrooms
    public int getBathrooms() {
        return bathrooms;
    }
    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    //get and set garden
    public boolean getGarden() {
        return false;
    }
    public boolean isGarden() {
        return garden;
    }
    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    //get and set price
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    //get and set status
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Properties() {
    }



    @Override
    public String toString() {
        return "Properties{" +
                "property_id=" + property_id +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", type='" + type + '\'' +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", garden=" + garden +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", seller=" + seller +
                '}';
    }


}
