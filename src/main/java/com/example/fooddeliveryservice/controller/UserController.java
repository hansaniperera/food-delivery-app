package com.example.fooddeliveryservice.controller;

import com.example.fooddeliveryservice.dto.ResponseDto;
import com.example.fooddeliveryservice.dto.UserDto;
import com.example.fooddeliveryservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "")
    public ResponseDto addAsset(@Valid @RequestBody UserDto user) {
        ResponseDto responseDto = new ResponseDto();
        userService.addUser(user);
        responseDto.setStatusCode(HttpStatus.CREATED.value());
        responseDto.setError(false);
        return responseDto;
    }


}
