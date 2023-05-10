package com.example.estateagency.service;

import com.example.estateagency.model.Buyers;
import com.example.estateagency.repo.BuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public Buyers getDepartment(Long id) {

        return this.repo.findById(id).get();

    }


    public Buyers createDepartment (Buyers dep){

        return this.repo.save(dep);

    }

    public Buyers deleteDepartment (long id){
        Buyers removed = this.getDepartment(id);
        this.repo.deleteById(id);
        return removed;

    }


}
