package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.dto.TransactionDto;

import java.sql.SQLException;
import java.text.ParseException;

public interface TransactionService {

    void performTransaction(TransactionDto transactionDto) throws ParseException, SQLException;
}
