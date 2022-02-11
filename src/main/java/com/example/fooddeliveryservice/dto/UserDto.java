package com.example.fooddeliveryservice.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Valid
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private Double cashBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(Double cashBalance) {
        this.cashBalance = cashBalance;
    }
}
