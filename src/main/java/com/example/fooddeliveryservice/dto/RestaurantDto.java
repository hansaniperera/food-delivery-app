package com.example.fooddeliveryservice.dto;

import com.example.fooddeliveryservice.entity.Menu;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class RestaurantDto {

    @NotEmpty
    private String restaurantName;
    @NotEmpty
    private Double cashBalance;
//    @NotEmpty
    private List<Menu> menu;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(Double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
}
