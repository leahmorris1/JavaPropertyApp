package com.example.estateagency.controller;

import com.example.estateagency.model.Sellers;
import com.example.estateagency.repo.SellerRepo;
import com.example.estateagency.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
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
        public Sellers readOne(@PathVariable long id ) {
            return service.getEmployee(id);
        }

        @PostMapping("/add")
        public Sellers add(@RequestBody Sellers newEmp){
            return service.createEmployee(newEmp);
        }

        @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable long id ) {
            service.deleteEmployee(id);
        }

    }
