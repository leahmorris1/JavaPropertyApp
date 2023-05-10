package com.example.estateagency.model;

import jakarta.persistence.*;

@Entity
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String type;
    String description;

    @ManyToOne
    private Sellers sellers;

    public Properties() {
    }

    public Properties(long id, String type, String description, Sellers sellers) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.sellers = sellers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sellers getEmployee() {
        return sellers;
    }

    public void setEmployee(Sellers sellers) {
        this.sellers = sellers;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", sellers=" + sellers +
                '}';
    }
}
