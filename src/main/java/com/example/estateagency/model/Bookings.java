package com.example.estateagency.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Entity
@Table(name = "bookings")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int booking_id;
    private String viewing_time;

    // A seller can have many properties
    // A property has one seller
    // A booking has a buyer and a property
    // A buyer can have many bookings
    // A property can have many bookings
    // - there is a many to many relationship between buyer and property, which we call a booking
    @ManyToOne
    @JoinColumn(name = "property_id")
    private Properties property;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyers buyer;

//join table

//constructor
    public Bookings(int booking_id, String viewing_time, Bookings booking) {
        this.booking_id = booking_id;
        this.viewing_time = viewing_time;

    }
//getters and setters
    public Properties getProperty() {
        return property;
    }
    public void setProperty(Properties property) {
        this.property = property;
    }
    public Buyers getBuyer() {
        return buyer;
    }
    public void setBuyer(Buyers buyer) {
        this.buyer = buyer;
    }

    public int getBooking_id() {
        return booking_id;
    }
    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getViewing_time() {
        return viewing_time;
    }
    public void setViewingTime(String viewingTime) {
    }

    public Bookings() {}

    @Override
    public String toString() {
        return "Bookings{" +
                "booking_id=" + booking_id +
                ", viewing_time='" + viewing_time + '\'' +
                '}';
    }

}