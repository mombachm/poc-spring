package com.sap.training.models;

import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AV_PRICE")
    private double averagePrice;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "IS_ALELO")
    private boolean alelo;

    @Column(name = "IMAGE")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    @Required
    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAlelo() {
        return this.alelo;
    }

    public void setAlelo(boolean alelo) {
        this.alelo = alelo;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
