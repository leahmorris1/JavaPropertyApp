package com.example.estateagency.service;

import com.example.estateagency.model.Sellers;
import com.example.estateagency.repo.SellerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public Sellers getEmployee(Long id) {

        return this.repo.findById(id).get();

    }


    public Sellers createEmployee (Sellers emp){

        return this.repo.save(emp);

    }

    public Sellers deleteEmployee (long id){
        Sellers removed = this.getEmployee(id);
        this.repo.deleteById(id);
        return removed;

    }

}
