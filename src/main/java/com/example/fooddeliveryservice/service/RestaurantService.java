package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.dto.ResAndMenuDto;
import com.example.fooddeliveryservice.dto.RestaurantDto;
import com.example.fooddeliveryservice.entity.Restaurant;
import com.example.fooddeliveryservice.enums.Days;
import com.example.fooddeliveryservice.enums.Inequality;

import java.time.LocalTime;
import java.util.List;

public interface RestaurantService {

    List<RestaurantDto> findByOpenTime(Days date, LocalTime openTime, LocalTime closeTime);

    ResAndMenuDto findByResNameAndDish(String searchTerm);

    void addRestaurant(RestaurantDto restaurantDto);
}
