package com.hanghae.delivery99.controller;


import com.hanghae.delivery99.dto.FoodDto;
import com.hanghae.delivery99.model.Food;
import com.hanghae.delivery99.repository.FoodRepository;
import com.hanghae.delivery99.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;
    private final FoodRepository foodRepository;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registFoods(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtoList){
        foodService.registFoods(foodDtoList, restaurantId);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFood(@PathVariable Long restaurantId){
        return foodRepository.findAllByRestaurantId(restaurantId);
    }

}
