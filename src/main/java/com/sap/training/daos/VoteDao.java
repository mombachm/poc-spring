package com.sap.training.daos;

import com.sap.training.models.Vote;

public interface VoteDao {
    void save(Vote vote);

    void update(Vote vote);
}
