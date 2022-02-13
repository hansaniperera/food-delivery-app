package com.example.fooddeliveryservice.repository;

import com.example.fooddeliveryservice.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionDetails, Long> {
}
