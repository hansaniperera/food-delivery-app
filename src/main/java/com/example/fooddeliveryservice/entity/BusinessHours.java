package com.example.fooddeliveryservice.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "business_hours")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BusinessHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "restaurant_id")
    private Long restaurantName;

    @Column(name = "open_time")
    private Date openTime;

    @Column(name = "close_time")
    private Date closeTime;

    @Column(name = "day")
    private Date day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(Long restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
