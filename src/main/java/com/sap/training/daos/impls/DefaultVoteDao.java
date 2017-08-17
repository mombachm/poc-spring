package com.sap.training.daos.impls;

import com.sap.training.daos.VoteDao;
import com.sap.training.models.Vote;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class DefaultVoteDao extends HibernateDaoSupport implements VoteDao {
    private SessionFactory sessionFactory;

    public void update(Vote vote) {
        getHibernateTemplate().merge(vote);
    }

    public void save(Vote vote) {
        getHibernateTemplate().save(vote);
    }
}
