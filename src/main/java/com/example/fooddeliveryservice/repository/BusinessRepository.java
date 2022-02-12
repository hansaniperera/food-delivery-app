package com.example.fooddeliveryservice.repository;

import com.example.fooddeliveryservice.entity.BusinessHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface BusinessRepository extends JpaRepository<BusinessHours, Long> {

    @Query("SELECT businessHours FROM BusinessHours businessHours WHERE businessHours.day = :day AND " +
            "CAST(businessHours.closeTime as time) >= CAST(:closeTime as time) AND "
            + "CAST(businessHours.openTime as time) <= CAST(:openTime as time)")
    Optional<BusinessHours> findByBusinessHours(@Param("day") String day, @Param("openTime") String openTime,
                                           @Param("closeTime") String closeTime);
}
