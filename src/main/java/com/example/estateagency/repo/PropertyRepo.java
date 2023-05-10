package com.example.estateagency.repo;


import com.example.estateagency.model.Properties;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropertyRepo extends CrudRepository<Properties,Long> {
    List<Properties> findAll();
}
