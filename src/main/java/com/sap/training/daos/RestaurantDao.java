package com.sap.training.daos;

import com.sap.training.models.Restaurant;

import java.util.List;

public interface RestaurantDao {

    void save(Restaurant restaurant);

    void update(Restaurant restaurant);

    List<Restaurant> listRestaurants();

    boolean deleteRestaurant(int id);

    Restaurant getRestaurant(int id);
}
