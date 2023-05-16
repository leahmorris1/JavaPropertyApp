package com.example.estateagency.service;

import com.example.estateagency.model.Buyers;
import com.example.estateagency.model.Sellers;
import com.example.estateagency.repo.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@Service
public class SellerService {
    @Autowired
    private SellerRepo repo;

    public SellerService(SellerRepo repo){
        this.repo = repo;
    }
    public SellerService(){

    }

    public List<Sellers> getAll() {
        return this.repo.findAll();
    }


    public Sellers getSeller(Long seller_id) {
        Optional<Sellers> seller = repo.findById(seller_id);
        if (seller.isPresent()) {
            return seller.get();
        } else {
            throw new RuntimeException("Resource not found"); }

    }

    public Sellers createSeller (Sellers seller){

        return this.repo.save(seller);

    }

    public Sellers deleteSeller (long seller_id){
        Sellers removed = this.getSeller(seller_id);
        this.repo.deleteById(seller_id);
        return removed;

    }

    public Sellers updateSeller (long seller_id, Sellers updatedSeller)
    {
        Sellers toUpdate = this.getSeller(seller_id);
        toUpdate.setFirstName(updatedSeller.getFirstName());
        toUpdate.setSurname(updatedSeller.getSurname());
        toUpdate.setAddress(updatedSeller.getAddress());
        toUpdate.setPostcode(updatedSeller.getPostcode());
        toUpdate.setPhone(updatedSeller.getPhone());

        return this.repo.save(toUpdate);
    }


}
