package com.example.fooddeliveryservice.dto;

import javax.validation.constraints.NotEmpty;

public class TransactionDto {

    @NotEmpty
    private Long restaurantId;
    @NotEmpty
    private Long customerId;
    @NotEmpty
    private Double amount;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
