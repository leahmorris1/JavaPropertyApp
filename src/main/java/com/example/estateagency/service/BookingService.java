package com.example.estateagency.service;

import com.example.estateagency.model.Bookings;
import com.example.estateagency.model.Sellers;
import com.example.estateagency.model.Buyers;
import com.example.estateagency.model.Properties;
import com.example.estateagency.repo.BookingRepo;
import com.example.estateagency.repo.BuyerRepo;
import com.example.estateagency.repo.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@Service
public class BookingService {
    @Autowired
    private BookingRepo repo;

    public BookingService(BookingRepo repo) {this.repo = repo;}
    public BookingService(){}

    public List<Bookings> getAll() {return this.repo.findAll();}

    public Bookings getBooking (Long booking_id){
        Optional<Bookings> booking = repo.findById(booking_id);
        if (booking.isPresent()) {
            return booking.get();
        } else {
            throw new RuntimeException("Booking not found");}
        }

        public Bookings createBooking (Bookings booking) {
            return this.repo.save(booking);
        }

        public Bookings deleteBooking (long booking_id){
        Bookings removed = this.getBooking(booking_id);
        this.repo.deleteById(booking_id);
        return removed;
        }

    public Bookings updateBooking(long booking_id, Bookings updatedBooking)
    {
        Bookings toUpdate = this.getBooking(booking_id);
        toUpdate.setProperty(updatedBooking.getProperty());
        toUpdate.setBuyer(updatedBooking.getBuyer());
        toUpdate.setViewingTime(updatedBooking.getViewing_time());
        return this.repo.save(toUpdate);
    }

}