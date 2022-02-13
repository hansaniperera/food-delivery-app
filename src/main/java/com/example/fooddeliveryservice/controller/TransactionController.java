package com.example.fooddeliveryservice.controller;


import com.example.fooddeliveryservice.dto.ResponseDto;
import com.example.fooddeliveryservice.dto.TransactionDto;
import com.example.fooddeliveryservice.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.SQLException;
import java.text.ParseException;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // transaction of purchasing a dish
    @PostMapping(value = "")
    public ResponseDto performTransaction(@Valid @RequestBody TransactionDto transactionDto) throws ParseException, SQLException {
        ResponseDto responseDto = new ResponseDto();
        transactionService.performTransaction(transactionDto);
        responseDto.setStatusCode(HttpStatus.CREATED.value());
        responseDto.setError(false);
        return responseDto;

    }
}
