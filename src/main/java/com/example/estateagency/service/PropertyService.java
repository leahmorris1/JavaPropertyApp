package com.example.estateagency.service;

import com.example.estateagency.model.Properties;
import com.example.estateagency.repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@Service
public class PropertyService {

    @Autowired
    private PropertyRepo repo;

    public PropertyService(PropertyRepo repo){
        this.repo = repo;
    }
    public PropertyService(){

    }

    public List<Properties> getAll() {
        return this.repo.findAll();
    }


    public Properties getProperty(Long property_id) {
        Optional<Properties> property = repo.findById(property_id);
        if (property.isPresent()) {
            return property.get();
        } else {
            throw new RuntimeException("Resource not found"); }

    }

    public Properties createProperty (Properties property){

        return this.repo.save(property);

    }

    public Properties deleteProperty (long property_id){
        Properties removed = this.getProperty(property_id);
        this.repo.deleteById(property_id);
        return removed;

    }


    public Properties updateProperty (long property_id, Properties updatedProperty)
    {
        Properties toUpdate = this.getProperty(property_id);
        toUpdate.setAddress(updatedProperty.getAddress());
        toUpdate.setPostcode(updatedProperty.getPostcode());
        toUpdate.setType(updatedProperty.getType());
        toUpdate.setBedrooms(updatedProperty.getBedrooms());
        toUpdate.setBedrooms(updatedProperty.getBathrooms());
        toUpdate.setGarden(updatedProperty.getGarden());
        toUpdate.setPrice(updatedProperty.getPrice());
        toUpdate.setStatus(updatedProperty.getStatus());

        return this.repo.save(toUpdate);
    }


    public Properties updatePartialProperty(long property_id, Properties partialProperty) {
        {
            Properties toUpdate = this.getProperty(property_id);
            toUpdate.setStatus(partialProperty.getStatus());
            return this.repo.save(toUpdate);
        }
    }
}
