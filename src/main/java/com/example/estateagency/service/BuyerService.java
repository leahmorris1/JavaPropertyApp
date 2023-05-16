package com.example.estateagency.service;

import com.example.estateagency.model.Buyers;
import com.example.estateagency.model.Sellers;
import com.example.estateagency.repo.BuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@Service
public class BuyerService {

    @Autowired
    private BuyerRepo repo;

    public BuyerService(BuyerRepo repo){
        this.repo = repo;
    }
    public BuyerService(){

    }

    public List<Buyers> getAll() {
        return this.repo.findAll();
    }


    public Buyers getBuyer(Long buyer_id) {
        Optional<Buyers> buyer = repo.findById(buyer_id);
        if (buyer.isPresent()) {
            return buyer.get();
        } else {
            throw new RuntimeException("Resource not found"); }

    }

    public Buyers createBuyer (Buyers buyer){

        return this.repo.save(buyer);

    }

    public Buyers deleteBuyer (long id){
        Buyers removed = this.getBuyer(id);
        this.repo.deleteById(id);
        return removed;

    }

    public Buyers updateBuyer (long buyer_id, Buyers updatedBuyer)
    {
        Buyers toUpdate = this.getBuyer(buyer_id);
        toUpdate.setFirstName(updatedBuyer.getFirstName());
        toUpdate.setSurname(updatedBuyer.getSurname());
        toUpdate.setAddress(updatedBuyer.getAddress());
        toUpdate.setPhone(updatedBuyer.getPhone());

        return this.repo.save(toUpdate);
    }

}