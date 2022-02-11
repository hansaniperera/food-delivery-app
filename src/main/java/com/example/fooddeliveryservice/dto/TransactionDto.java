package com.example.fooddeliveryservice.dto;

import javax.validation.constraints.NotEmpty;

public class TransactionDto {

    @NotEmpty
    private Integer restaurantId;
    @NotEmpty
    private Integer customerId;
    @NotEmpty
    private Double amount;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
