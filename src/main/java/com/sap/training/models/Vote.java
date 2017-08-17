package com.sap.training.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "VOTE")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @NotNull
    private int id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="VOTING_ID")
    private Voting voting;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="RESTAURANT_ID")
    private Restaurant restaurant;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Voting getVoting() {
        return this.voting;
    }

    public void setVoting(Voting voting) {
        this.voting = voting;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
