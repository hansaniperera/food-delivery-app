package com.example.fooddeliveryservice.service.impl;

import com.example.fooddeliveryservice.dto.RestaurantDto;
import com.example.fooddeliveryservice.entity.BusinessHours;
import com.example.fooddeliveryservice.entity.Restaurant;
import com.example.fooddeliveryservice.enums.Days;
import com.example.fooddeliveryservice.enums.Inequality;
import com.example.fooddeliveryservice.exception.CustomException;
import com.example.fooddeliveryservice.repository.BusinessRepository;
import com.example.fooddeliveryservice.repository.RestaurantRepository;
import com.example.fooddeliveryservice.service.RestaurantService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    RestaurantRepository restaurantRepository;
    BusinessRepository businessRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, BusinessRepository businessRepository) {
        this.restaurantRepository = restaurantRepository;
        this.businessRepository = businessRepository;
    }

    @Transactional
    public  List<Restaurant> findByOpenTime(Days date, LocalTime openTime, LocalTime closeTime){

        List<Restaurant> restaurantList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        Optional<BusinessHours> businessHours = businessRepository.
                findByBusinessHours(date.toString(), openTime.format(formatter), closeTime.format(formatter));

        if (businessHours.isPresent()) {
           restaurantList.add(businessHours.map(BusinessHours::getRestaurant).orElseThrow(() -> new CustomException(432, "messageSource.getMessage(String.valueOf(ERROR_432)")));
        }


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
