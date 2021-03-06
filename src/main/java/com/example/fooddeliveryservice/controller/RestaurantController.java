package com.example.fooddeliveryservice.controller;

import com.example.fooddeliveryservice.dto.ResponseDto;
import com.example.fooddeliveryservice.dto.RestaurantDto;
import com.example.fooddeliveryservice.enums.Days;
import com.example.fooddeliveryservice.enums.Inequality;
import com.example.fooddeliveryservice.service.MenuService;
import com.example.fooddeliveryservice.service.RestaurantService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;


@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final MenuService menuService;

    public RestaurantController(RestaurantService restaurantService, MenuService menuService) {
        this.restaurantService = restaurantService;
        this.menuService = menuService;
    }

    // list of restaurants by open time
    @GetMapping(value = "/open-time")
    public ResponseDto findByOpenTime(@RequestParam(name = "date") Days date,
            @RequestParam(name = "open_time", required = false)
            @DateTimeFormat(pattern = "HH:mm:ss") LocalTime openTime,
            @RequestParam(name = "close_time", required = false)
            @DateTimeFormat(pattern = "HH:mm:ss") LocalTime closeTime) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatusCode(HttpStatus.OK.value());
        responseDto.setError(false);
        responseDto.setBody(restaurantService.findByOpenTime(date, openTime, closeTime));
        return responseDto;
    }

    // list of restaurants by price range
    @GetMapping(value = "/price-range")
    public ResponseDto findByPriceRange(@RequestParam(name = "noOfRestaurants") Integer noOfRestaurants,
                                      @RequestParam(name = "noOfDishes", required = false) Integer noOfDishes,
                                      @RequestParam(name = "inequality", required = false) Inequality inequality,
                                      @RequestParam(name = "minPrice", required = false) Double minPrice,
                                      @RequestParam(name = "maxPrice", required = false) Double maxPrice) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatusCode(HttpStatus.OK.value());
        responseDto.setError(false);
        responseDto.setBody(menuService.findByPriceRange(noOfRestaurants,noOfDishes,inequality, minPrice, maxPrice));
        return responseDto;
    }

    // list of restaurants/dishes by search term
    @GetMapping(value = "")
    public ResponseDto findByResNameAndDish(@RequestParam(name = "searchTerm") String searchTerm) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatusCode(HttpStatus.OK.value());
        responseDto.setError(false);
        responseDto.setBody(restaurantService.findByResNameAndDish(searchTerm));
        return responseDto;
    }

    // save new restaurant
    @PostMapping(value = "")
    public ResponseDto addAsset(@Valid @RequestBody RestaurantDto restaurant) {
        ResponseDto responseDto = new ResponseDto();
        restaurantService.addRestaurant(restaurant);
        responseDto.setStatusCode(HttpStatus.CREATED.value());
        responseDto.setError(false);
        return responseDto;
    }
}
