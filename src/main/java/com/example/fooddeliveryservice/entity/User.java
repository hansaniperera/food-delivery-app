package com.example.fooddeliveryservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cash_balance")
    private Double cashBalance;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    List<PurchaseHistory> purchaseHistory;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    List<TransactionDetails> transactionDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<PurchaseHistory> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<PurchaseHistory> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public List<TransactionDetails> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
