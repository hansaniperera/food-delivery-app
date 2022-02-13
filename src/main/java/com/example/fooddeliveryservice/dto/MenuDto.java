package com.example.fooddeliveryservice.dto;

import javax.validation.constraints.NotEmpty;

public class MenuDto {

    @NotEmpty
    private String dishName;

    @NotEmpty
    private Double price;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
