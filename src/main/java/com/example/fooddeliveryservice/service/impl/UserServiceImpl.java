package com.example.fooddeliveryservice.service.impl;

import com.example.fooddeliveryservice.dto.UserDto;
import com.example.fooddeliveryservice.entity.User;
import com.example.fooddeliveryservice.repository.UserRepository;
import com.example.fooddeliveryservice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void addUser(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userRepository.save(user);
    }
}
