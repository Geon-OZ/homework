package com.hanghae.delivery99.service;


import com.hanghae.delivery99.dto.FoodDto;
import com.hanghae.delivery99.model.Food;
import com.hanghae.delivery99.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;


    @Transactional
    public void registFoods(List<FoodDto> foodDtos, Long id){
        List<Food> foodList = foodRepository.findAllByRestaurantId(id);

        for (int i = 0; i < foodList.size(); i++) {
            for (int j = i + 1; j < foodDtos.size(); j++) {
                // 등록 할 메뉴와 기존 메뉴의 이름이 같을 때 에러 발생
                if (foodList.get(i).getName().equals(foodDtos.get(j - 1).getName())) {
                    throw new IllegalArgumentException("중복된 메뉴가 존재합니다.");
                    // 중복 된 메뉴가 있을 때 에러 발생
                } else if (foodDtos.get(i).getName().equals(foodDtos.get(j).getName())) {
                    throw new IllegalArgumentException("중복된 메뉴가 존재합니다.");
                }
            }
        }


        for (FoodDto foodDto : foodDtos){
            int foodPriceCheck = foodDto.getPrice();
            Food result = new Food(id, foodDto);
            if (foodPriceCheck < 100 || foodPriceCheck > 100000){
                throw new NullPointerException("100원 이상 100,000원 이하로 설정해주세요.");
            } else if (foodPriceCheck%100 != 0) {
                throw new NullPointerException("100원 단위로 설정해주세요.");
            }
            foodRepository.save(result);
        }

        }

    }

