package com.example.estateagency.controller;

import com.example.estateagency.model.Buyers;
import com.example.estateagency.repo.BuyerRepo;
import com.example.estateagency.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    BuyerService service;

    @Autowired
    BuyerRepo mRepo;

    @GetMapping("/read")
    public List<Buyers> read() {
        return service.getAll();
    }

    @GetMapping("/read/{id}")
    public Buyers readOne(@PathVariable long id ) {
        return service.getBuyer(id);
    }

    @PostMapping("/add")
    public Buyers add(@RequestBody Buyers newDep){
        return service.createBuyer(newDep);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id ) {
        service.deleteBuyer(id);
    }

    @PutMapping ("/update/{buyer_id}")
    public Buyers updateBuyer (@PathVariable long buyer_id,
                               @RequestBody Buyers updatedBuyer){
        return this.service.updateBuyer(buyer_id, updatedBuyer);
    }
}
