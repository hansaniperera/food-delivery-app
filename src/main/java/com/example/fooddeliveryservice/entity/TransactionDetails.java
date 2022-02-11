package com.example.fooddeliveryservice.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "restaurant")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column(name = "amount")
    private String amount;

    @Column(name = "added_date")
    private Date addedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private Date description;



}
