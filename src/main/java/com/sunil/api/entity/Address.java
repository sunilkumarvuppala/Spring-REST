/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunil.api.entity;

/**
 *
 * @author SUNIL VUPPALA
 */
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Address {
    @Id
    private String id;
    
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(){
        this.id = UUID.randomUUID().toString();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + '}';
    }
    
    
    
}

