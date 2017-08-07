package com.sap.training.daos.impls;

import com.sap.training.daos.RestaurantDao;
import com.sap.training.models.Restaurant;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DefaultRestaurantDao extends HibernateDaoSupport implements RestaurantDao{

    private SessionFactory sessionFactory;

    @Override
    public List<Restaurant> listRestaurants() {
        return (List<Restaurant>) getHibernateTemplate()
                .find("from com.sap.training.models.Restaurant");
    }

    @Transactional
    public boolean deleteRestaurant(int id) {
        Restaurant removeRestaurant;
        removeRestaurant = getRestaurant(id);
        try {
            if (removeRestaurant != null) {
                getHibernateTemplate().delete(removeRestaurant);
                return true;
            } else {
                return  false;
            }
        }catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public Restaurant getRestaurant(int id) {
        return getHibernateTemplate().get(Restaurant.class, id);
    }

    @Transactional
    public void save(Restaurant restaurant) {
        getHibernateTemplate().save(restaurant);
    }
}
