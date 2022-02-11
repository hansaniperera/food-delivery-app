package com.example.fooddeliveryservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurant")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String restaurantName;

    @Column(name = "cash_balance")
    private Double cashBalance;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Menu> menu;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<BusinessHours> businessHours;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<TransactionDetails> transactionDetails;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<BusinessHours> getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(List<BusinessHours> businessHours) {
        this.businessHours = businessHours;
    }

    public List<TransactionDetails> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
