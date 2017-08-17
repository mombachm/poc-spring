package com.sap.training.models;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @NotNull
    private int id;

    @Column(name = "NAME")
    @NotBlank
    private String name;

    @Column(name = "AV_PRICE")
    @Digits(integer = 3 /*precision*/, fraction = 2 /*scale*/, message = "Invalid value")
    @Min(1)
    private double averagePrice;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "IS_ALELO")
    private boolean alelo;

    @Column(name = "IMAGE")
    private String image;

    @OneToMany(mappedBy="restaurant")
    private List<Vote> votes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

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

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
