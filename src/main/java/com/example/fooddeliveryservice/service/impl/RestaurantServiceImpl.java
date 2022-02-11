package com.example.fooddeliveryservice.service.impl;

import com.example.fooddeliveryservice.dto.RestaurantDto;
import com.example.fooddeliveryservice.entity.Restaurant;
import com.example.fooddeliveryservice.enums.Days;
import com.example.fooddeliveryservice.enums.Inequality;
import com.example.fooddeliveryservice.repository.RestaurantRepository;
import com.example.fooddeliveryservice.service.RestaurantService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public  List<Restaurant> findByOpenTime(Days date, LocalTime openTime, LocalTime closeTime){
        List<Restaurant> restaurantList = new ArrayList<>();
        return restaurantList;
    }

    public List<Restaurant> findByPriceRange(Integer noOfRestaurants, Integer noOfDishes, Inequality inequality, Double minPrice, Double maxPrice){
        List<Restaurant> restaurantList = new ArrayList<>();
        return restaurantList;
    }

    public List<Restaurant> findByResNameAndDish(String searchTerm){
        List<Restaurant> restaurantList = new ArrayList<>();
        return restaurantList;
    }

    public void addRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantDto, restaurant);
        restaurantRepository.save(restaurant);
    }
}
