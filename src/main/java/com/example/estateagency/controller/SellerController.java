package com.example.estateagency.controller;

import com.example.estateagency.model.Sellers;
import com.example.estateagency.repo.SellerRepo;
import com.example.estateagency.service.SellerService;
import org.hibernate.annotations.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/seller")
public class SellerController {
        @Autowired
        SellerRepo mRepo;

        @Autowired
        SellerService service;

        @GetMapping("/read")
        public List<Sellers> read() {
            return service.getAll();
        }

        @GetMapping("/read/{id}")
        public Sellers readOne(@PathVariable long seller_id ) {
            return service.getSeller(seller_id);
        }

        @PostMapping("/add")
        public Sellers add(@RequestBody Sellers newSeller){
            return service.createSeller(newSeller);
        }

        @DeleteMapping("/delete/{seller_id}")
        public void delete(@PathVariable long seller_id ) {
            service.deleteSeller(seller_id);
        }

    @PutMapping ("/update/{seller_id}")
    public Sellers updateSeller (@PathVariable long seller_id,
                               @RequestBody Sellers updatedSeller){
        return this.service.updateSeller(seller_id, updatedSeller);
    }
}
