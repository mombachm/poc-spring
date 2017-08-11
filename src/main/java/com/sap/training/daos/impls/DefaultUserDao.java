package com.sap.training.daos.impls;

import com.sap.training.daos.UserDao;
import com.sap.training.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DefaultUserDao extends HibernateDaoSupport implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public DefaultUserDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user){
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void deleteUser(String email){
        getHibernateTemplate().delete(getUserByEmail(email));
    }

    @Override
    public User getUserByEmail(String email){
        try(Session session = sessionFactory.openSession()){
            DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
            criteria.add(Restrictions.like("email", email, MatchMode.ANYWHERE));
            return (User) criteria.getExecutableCriteria(session).uniqueResult();
        }
    }
}
