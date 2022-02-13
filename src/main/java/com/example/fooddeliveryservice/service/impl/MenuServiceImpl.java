package com.example.fooddeliveryservice.service.impl;

import com.example.fooddeliveryservice.dto.RestaurantDto;
import com.example.fooddeliveryservice.entity.Restaurant;
import com.example.fooddeliveryservice.enums.Inequality;
import com.example.fooddeliveryservice.repository.MenuRepository;
import com.example.fooddeliveryservice.repository.RestaurantRepository;
import com.example.fooddeliveryservice.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;
    private RestaurantRepository restaurantRepository;

    public MenuServiceImpl(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<RestaurantDto> findByPriceRange(Integer noOfRestaurants, Integer noOfDishes, Inequality inequality,
                                                Double minPrice, Double maxPrice){
        List<RestaurantDto> restaurantList = new ArrayList<>();
        List<Integer> restaurantIdList = null;

        if (inequality.equals(Inequality.GREATER)) {
            restaurantIdList = menuRepository.findByPriceRangeGreater(maxPrice, minPrice, noOfDishes);
        } else {
            restaurantIdList = menuRepository.findByPriceRangeLesser(maxPrice, minPrice, noOfDishes);
        }

        for (Integer integer : restaurantIdList) {
            Restaurant restaurant = restaurantRepository.getById(Long.parseLong(integer.toString()));
            RestaurantDto restaurantDto = new RestaurantDto();
//            BeanUtils.copyProperties(restaurant, restaurantDto);
            restaurantDto.setRestaurantName(restaurant.getRestaurantName());
            restaurantDto.setCashBalance(restaurant.getCashBalance());
            restaurantList.add(restaurantDto);
        }

        Collections.sort(restaurantList, (i1, i2) -> (i2.getCashBalance().compareTo(i1.getCashBalance())));
        return restaurantList.subList(0, noOfRestaurants);
    }
}
