package com.example.fooddeliveryservice.dto;

import com.example.fooddeliveryservice.entity.Menu;
import com.example.fooddeliveryservice.entity.MenuProjection;
import com.example.fooddeliveryservice.entity.RestaurantProjection;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class ResAndMenuDto {

    @NotEmpty
    private List<MenuProjection> menuProjections;
    @NotEmpty
    private List<RestaurantProjection> restaurantProjections;

    public List<MenuProjection> getMenuProjections() {
        return menuProjections;
    }

    public void setMenuProjections(List<MenuProjection> menuProjections) {
        this.menuProjections = menuProjections;
    }

    public List<RestaurantProjection> getRestaurantProjections() {
        return restaurantProjections;
    }

    public void setRestaurantProjections(List<RestaurantProjection> restaurantProjections) {
        this.restaurantProjections = restaurantProjections;
    }
}
