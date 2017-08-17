package com.sap.training.services;

import com.sap.training.models.User;
import com.sap.training.models.Vote;
import com.sap.training.models.Voting;

import java.util.List;

public interface VotingService {

    void createVoting(Voting voting);

    List<Voting> listVotings();

    Voting getVotingById(int id);

    //void addVote(Vote vote);

}

