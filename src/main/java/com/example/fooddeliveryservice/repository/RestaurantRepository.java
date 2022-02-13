package com.example.fooddeliveryservice.repository;

import com.example.fooddeliveryservice.entity.Restaurant;
import com.example.fooddeliveryservice.entity.RestaurantProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

   @Query("SELECT res FROM Restaurant res WHERE res.restaurantName LIKE %:searchKey%)")
   List<RestaurantProjection> findBySearchTerm(@Param("searchTerm") String searchTerm);

   }
