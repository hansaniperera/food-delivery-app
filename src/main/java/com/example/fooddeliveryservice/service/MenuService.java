package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.dto.RestaurantDto;
import com.example.fooddeliveryservice.enums.Inequality;

import java.util.List;

public interface MenuService {

    List<RestaurantDto> findByPriceRange(Integer noOfRestaurants, Integer noOfDishes, Inequality inequality, Double minPrice, Double maxPrice);
}
