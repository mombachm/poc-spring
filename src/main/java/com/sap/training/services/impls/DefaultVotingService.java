package com.sap.training.services.impls;

import com.sap.training.daos.VotingDao;
import com.sap.training.models.User;
import com.sap.training.models.Vote;
import com.sap.training.models.Voting;
import com.sap.training.services.VotingService;

import javax.annotation.Resource;
import java.util.List;

public class DefaultVotingService implements VotingService {

    @Resource
    private VotingDao votingDao;

    public void createVoting(Voting voting){
        votingDao.save(voting);
    }

    public List<Voting> listVotings(){
        return votingDao.listVotings();
    }

    public Voting getVotingById(int id) { return votingDao.getVotingById(id); }

}
