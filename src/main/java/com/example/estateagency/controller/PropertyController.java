package com.example.estateagency.controller;

import com.example.estateagency.model.Properties;
import com.example.estateagency.repo.PropertyRepo;
import com.example.estateagency.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class PropertyController {


        @Autowired
        PropertyRepo mRepo;


    @Autowired
    PropertyService service;

    public PropertyController(PropertyService service){
        this.service = service;
    }



        @GetMapping("/read")
        public List<Properties> read() {
            return service.getAll();
        }

        @GetMapping("/read/{id}")
        public Properties readOne(@PathVariable long id ) {
            return service.getAddress(id);
        }

        @PostMapping("/add")
        public Properties add(@RequestBody Properties newAddr){
            return this.service.createAddress(newAddr);
        }

        @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable long id ) {
            service.deleteAddress(id);
        }

    }
