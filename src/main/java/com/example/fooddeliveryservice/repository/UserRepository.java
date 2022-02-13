package com.example.fooddeliveryservice.repository;

import com.example.fooddeliveryservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    @Modifying
    @Query(nativeQuery = true, value =("UPDATE customer SET cash_balance = :cashBalance WHERE id = :userId"))
    void updateUserDetails(@Param("userId") Long userId, @Param("cashBalance") Double cashBalance);

}
