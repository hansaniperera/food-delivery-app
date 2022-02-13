package com.example.fooddeliveryservice.service.impl;

import com.example.fooddeliveryservice.dto.MenuDto;
import com.example.fooddeliveryservice.dto.ResAndMenuDto;
import com.example.fooddeliveryservice.dto.RestaurantDto;
import com.example.fooddeliveryservice.entity.MenuProjection;
import com.example.fooddeliveryservice.entity.Restaurant;
import com.example.fooddeliveryservice.entity.RestaurantProjection;
import com.example.fooddeliveryservice.enums.Days;
import com.example.fooddeliveryservice.repository.BusinessRepository;
import com.example.fooddeliveryservice.repository.MenuRepository;
import com.example.fooddeliveryservice.repository.RestaurantRepository;
import com.example.fooddeliveryservice.service.RestaurantService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    RestaurantRepository restaurantRepository;
    BusinessRepository businessRepository;
    MenuRepository menuRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, BusinessRepository businessRepository,
                                 MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.businessRepository = businessRepository;
        this.menuRepository = menuRepository;
    }

    @Transactional
    public  List<RestaurantDto> findByOpenTime(Days date, LocalTime openTime, LocalTime closeTime){

        List<RestaurantDto> restaurantList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        List<RestaurantProjection> restaurants = businessRepository.
                findByBusinessHours(date.toString(), openTime.format(formatter), closeTime.format(formatter));

        for (RestaurantProjection restaurant : restaurants) {
            RestaurantDto restaurantDto = new RestaurantDto();
            restaurantDto.setRestaurantName(restaurant.getRestaurantName());
            restaurantDto.setCashBalance(restaurant.getCashBalance());
            restaurantList.add(restaurantDto);
        }
        return restaurantList;
    }



    public ResAndMenuDto findByResNameAndDish(String searchTerm){
        ResAndMenuDto resAndMenuDtos = new ResAndMenuDto();

        List<RestaurantProjection> restaurantList = restaurantRepository.findBySearchTerm(searchTerm);
        List<MenuProjection> menuList = menuRepository.findBySearchTerm(searchTerm);
        resAndMenuDtos.setMenuProjections(menuList);
        resAndMenuDtos.setRestaurantProjections(restaurantList);
        return resAndMenuDtos;
    }

    public void addRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        BeanUtils.copyProperties(restaurantDto, restaurant);
        restaurantRepository.save(restaurant);
    }
}
