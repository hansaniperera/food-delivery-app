package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.dto.RestaurantDto;
import com.example.fooddeliveryservice.entity.Restaurant;
import com.example.fooddeliveryservice.enums.Days;
import com.example.fooddeliveryservice.enums.Inequality;

import java.time.LocalTime;
import java.util.List;

public interface RestaurantService {

    List<Restaurant> findByOpenTime(Days date, LocalTime openTime, LocalTime closeTime);

    List<Restaurant> findByPriceRange(Integer noOfRestaurants, Integer noOfDishes, Inequality inequality, Double minPrice, Double maxPrice);

    List<Restaurant> findByResNameAndDish(String searchTerm);

    void addRestaurant(RestaurantDto restaurantDto);
}
