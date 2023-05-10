package com.example.estateagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Buyers {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long Id;


    private String departmentName;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Sellers> getEmployees() {
        return sellers;
    }


    public void setEmployees(List<Sellers> sellers) {
        this.sellers = sellers;
    }


    @OneToMany(mappedBy = "buyers", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Sellers> sellers;

    @Override
    public String toString() {
        return "Buyers{" +
                "Id=" + Id +
                ", departmentName='" + departmentName + '\'' +
                ", sellers=" + sellers +
                '}';
    }
}
