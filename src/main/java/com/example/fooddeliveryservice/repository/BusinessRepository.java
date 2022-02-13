package com.example.fooddeliveryservice.repository;

import com.example.fooddeliveryservice.entity.BusinessHours;
import com.example.fooddeliveryservice.entity.Restaurant;
import com.example.fooddeliveryservice.entity.RestaurantProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusinessRepository extends JpaRepository<BusinessHours, Long> {

    @Query(nativeQuery = true, value =("SELECT res.id AS id, res.name AS restaurantName, res.cash_balance AS cashBalance FROM business_hours AS businessHours INNER JOIN restaurant AS res ON " +
            "res.id = businessHours.restaurant_id WHERE businessHours.day = :day AND " +
            "CAST(businessHours.close_time as time) >= CAST(:closeTime as time) AND "
            + "CAST(businessHours.open_time as time) <= CAST(:openTime as time)"))
    List<RestaurantProjection> findByBusinessHours(@Param("day") String day, @Param("openTime") String openTime,
                                                   @Param("closeTime") String closeTime);
}
