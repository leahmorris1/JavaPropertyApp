package com.example.estateagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int age;
    @ManyToOne
    private Buyers buyers;

    @OneToMany(mappedBy = "sellers", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Properties> propertiesList;

    public long getId() {
        return id;
    }

    public Sellers(long id, String firstName, String lastName, String dateOfBirth, int age, Buyers buyers, List<Properties> propertiesList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.buyers = buyers;
        this.propertiesList = propertiesList;
    }

    public Sellers() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Buyers getDepartment() {
        return buyers;
    }

    public void setDepartment(Buyers buyers) {
        this.buyers = buyers;
    }

    public List<Properties> getAddressList() {
        return propertiesList;
    }

    public void setAddressList(List<Properties> propertiesList) {
        this.propertiesList = propertiesList;
    }

    @Override
    public String toString() {
        return "Sellers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", age=" + age +
                ", buyers=" + buyers +
                ", propertiesList=" + propertiesList +
                '}';
    }
}
