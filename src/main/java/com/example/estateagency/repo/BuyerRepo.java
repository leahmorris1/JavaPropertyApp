package com.example.estateagency.repo;

import com.example.estateagency.model.Buyers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BuyerRepo extends CrudRepository<Buyers,Long> {
    List<Buyers> findAll();
}