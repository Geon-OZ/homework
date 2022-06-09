package com.hanghae.delivery99.controller;


import com.hanghae.delivery99.dto.RestaurantDto;
import com.hanghae.delivery99.model.Restaurant;
import com.hanghae.delivery99.repository.RestaurantRepository;
import com.hanghae.delivery99.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;

    @PostMapping("/restaurant/register")
    public Restaurant registRestaurants(@RequestBody RestaurantDto restaurantDto){
        return restaurantService.registRestaurants(restaurantDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantRepository.findAll();
    }
}