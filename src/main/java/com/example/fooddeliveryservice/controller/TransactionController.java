package com.example.fooddeliveryservice.controller;


import com.example.fooddeliveryservice.dto.ResponseDto;
import com.example.fooddeliveryservice.dto.TransactionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    // transaction of purchasing a dish
    @PostMapping(value = "")
    public ResponseDto performTransaction(@Valid @RequestBody TransactionDto transactionDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatusCode(HttpStatus.CREATED.value());
        responseDto.setError(false);
        return responseDto;
    }
}
