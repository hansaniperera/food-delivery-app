package com.example.fooddeliveryservice.service.impl;

import com.example.fooddeliveryservice.dto.TransactionDto;
import com.example.fooddeliveryservice.entity.Restaurant;
import com.example.fooddeliveryservice.entity.TransactionDetails;
import com.example.fooddeliveryservice.entity.User;
import com.example.fooddeliveryservice.repository.RestaurantRepository;
import com.example.fooddeliveryservice.repository.TransactionRepository;
import com.example.fooddeliveryservice.repository.UserRepository;
import com.example.fooddeliveryservice.service.TransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(UserRepository userRepository, RestaurantRepository restaurantRepository,
                                  TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.transactionRepository = transactionRepository;
    }


    @Transactional(rollbackFor = { SQLException.class })
    public void performTransaction(TransactionDto transactionDto) throws ParseException, SQLException {
        TransactionDetails transactionDetails = new TransactionDetails();
        BeanUtils.copyProperties(transactionDto, transactionDetails);

        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("DD-MM-YYYY HH:MM:SS");
        String date = dateTimeFormatter.format(new Date());
        transactionDetails.setAddedDate(dateTimeFormatter.parse(date));
        transactionDetails.setAmount(transactionDto.getAmount());
        User customer = userRepository.getById(transactionDto.getCustomerId());
        Restaurant restaurant = restaurantRepository.getById(transactionDto.getRestaurantId());
        transactionDetails.setCustomer(customer);
        transactionDetails.setRestaurant(restaurant);
        try {
            // Calculate new wallet balances
            Double customerCashBalance = customer.getCashBalance() - transactionDto.getAmount();
            Double restaurantCashBalance = restaurant.getCashBalance() + transactionDto.getAmount();

            // Commit wallet adjustments
            userRepository.updateUserDetails(customer.getId(), customerCashBalance);
            restaurantRepository.updateResDetails(restaurant.getId(), restaurantCashBalance);

            // Update transaction details
            transactionDetails.setDescription("Transaction Successful");
            transactionDetails.setStatus("SUCCESS");
            transactionRepository.save(transactionDetails);
        }catch (Exception e) {
            transactionDetails.setDescription("Transaction Failed");
            transactionDetails.setStatus("FAILED");
            transactionRepository.save(transactionDetails);
            throw new SQLException("Throwing exception for Transaction Rollback");
        }
    }
}
