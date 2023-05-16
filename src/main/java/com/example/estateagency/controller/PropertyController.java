package com.example.estateagency.controller;

import com.example.estateagency.model.Properties;
import com.example.estateagency.model.Sellers;
import com.example.estateagency.repo.PropertyRepo;
import com.example.estateagency.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/properties")
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
            return service.getProperty(id);
        }

        @PostMapping("/add")
        public Properties add(@RequestBody Properties newProperty){
            return this.service.createProperty(newProperty);
        }
        @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable long id ) {
            service.deleteProperty(id);
        }

    @PutMapping ("/update/{property_id}")
    public Properties updateProperty (@PathVariable long property_id,
                                 @RequestBody Properties updatedProperty){
        return this.service.updateProperty(property_id, updatedProperty);
    }
    @PatchMapping ("/updatepartial/{property_id}")
    public Properties updatePartialProperty (@PathVariable ("property_id") long property_id,
                                             @RequestBody Properties partialProperty){
        service.updatePartialProperty(property_id, partialProperty);
        return partialProperty;
    }

}
