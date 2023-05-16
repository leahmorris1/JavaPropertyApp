package com.example.estateagency.controller;

import com.example.estateagency.model.Bookings;
import com.example.estateagency.model.Sellers;
import com.example.estateagency.model.Buyers;
import com.example.estateagency.repo.BookingRepo;
import com.example.estateagency.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingRepo bRepo;
    @Autowired
    BookingService service;

    @GetMapping("/read")
    public List<Bookings> read () {return service.getAll();}

    @GetMapping("/read/{id}")
    public Bookings readOne(@PathVariable long booking_id) {return service.getBooking(booking_id);}

    @PostMapping("/add")
    public Bookings add (@RequestBody Bookings newBooking){
        return service.createBooking(newBooking);}

    @DeleteMapping("/delete/{booking_id}")
    public void delete (@PathVariable long booking_id) {service.deleteBooking(booking_id);}

    @PutMapping("/update/{booking_id}")
    public Bookings updateBooking (@PathVariable long booking_id,
                                   @RequestBody Bookings updatedBooking){
        return this.service.updateBooking(booking_id, updatedBooking);}

}
