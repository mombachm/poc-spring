package com.sap.training.services.impls;

import com.sap.training.daos.RestaurantDao;
import com.sap.training.models.Restaurant;
import com.sap.training.services.RestaurantService;

import javax.annotation.Resource;
import java.util.List;


public class DefaultRestaurantService implements RestaurantService {

    @Resource
    private RestaurantDao restaurantDao;

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantDao.save(restaurant);
    }

    @Override
    public List<Restaurant> listRestaurants() {
        return restaurantDao.listRestaurants();
    }

    @Override
    public boolean deleteRestaurant(int deleteId) {
        return restaurantDao.deleteRestaurant(deleteId);
    }


}
