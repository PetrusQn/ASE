package com.dhbw.advsoft.project.wms.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name="address")
public class Address {

    @Column(name="country")
    private String country;

    @Id
    @Column(name="id")
    private int id;

    @Column(name="zip_code")
    private int zipCode;

    @Column(name="city")
    private String city;

    @Column(name="street")
    private String street;

    @Column(name="house_number")
    private int houseNumber;

    public Address() {}

    public Address(String country, int zipCode, String city, String street, int houseNumber) {
        this.country = country;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.id = ThreadLocalRandom.current().nextInt(0, 999999);
    }

    public String getCountry() {
        return this.country;
    }

    public int getId() {
        return this.id;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }
}
