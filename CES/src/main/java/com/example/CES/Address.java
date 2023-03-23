package com.example.CES;

import jakarta.persistence.*;

@Entity
@Table (name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AddressID")
    private int id;

    @Column(name = "street_name")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="state", length=2)
    private String state;

    @Column(name="zip_code", length=5)
    private int zipCode;


    public int getId() {
        return id;
    }

    public String getStreetName() {
        return street;
    }

    public void setStreetName(String streetName) {
        this.street = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


}
