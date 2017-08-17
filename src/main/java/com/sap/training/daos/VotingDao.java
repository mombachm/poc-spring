package com.sap.training.daos;

import com.sap.training.models.User;
import com.sap.training.models.Vote;
import com.sap.training.models.Voting;

import java.util.List;

public interface VotingDao {

    void save(Voting voting);

    void update(Voting voting);

    List<Voting> listVotings();

    void addUpdateVote(Vote vote);

    Voting getVotingById(int id);

}
