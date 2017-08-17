package com.sap.training.models;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "VOTING")
public class Voting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @NotNull
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "voting", cascade = CascadeType.ALL)
    private List<Vote> votes;

    public Voting(String name){
        this.setName(name);
    }

    public Voting(){
        this.setName("Voting" + this.getId());
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vote> getVotes() {
        return this.votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public Vote getUserVote(User user) {
        for(Vote vote : this.votes)  {
           User voteUser = vote.getUser();
           if(voteUser != null && voteUser.getId() == user.getId()) {
               return vote;
           }
        }
        return new Vote();
    }
}

