package com.sap.training.services.impls;

import com.sap.training.daos.VoteDao;
import com.sap.training.models.Vote;
import com.sap.training.models.Voting;
import com.sap.training.services.VoteService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class DefaultVoteService implements VoteService{
    @Resource
    private VoteDao voteDao;

    @Override
    @Transactional
    public void registerVote(Vote vote) {
        if(vote.getId() > 0) {
            voteDao.update(vote);
        } else {
            voteDao.save(vote);
        }
    }
}
