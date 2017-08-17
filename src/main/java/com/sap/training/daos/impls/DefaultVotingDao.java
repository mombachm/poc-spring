package com.sap.training.daos.impls;

import com.sap.training.daos.VotingDao;
import com.sap.training.models.User;
import com.sap.training.models.Vote;
import com.sap.training.models.Voting;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DefaultVotingDao extends HibernateDaoSupport implements VotingDao{
    private SessionFactory sessionFactory;

    @Transactional
    public void save(Voting voting) {
        getHibernateTemplate().save(voting);
    }

    @Transactional
    public void update(Voting voting) {
        getHibernateTemplate().update(voting);
    }

    @Override
    public List<Voting> listVotings() {
        return (List<Voting>) getHibernateTemplate()
                .find("from com.sap.training.models.Voting");
    }

    @Override
    public Voting getVotingById(int id) {
        return getHibernateTemplate().get(Voting.class, id);
    }

    @Override
    public void addUpdateVote(Vote vote) {
        if(getVotingById(vote.getId()) != null) {

        } else {

        }
    }
}
