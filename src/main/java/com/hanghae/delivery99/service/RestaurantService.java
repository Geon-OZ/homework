package com.hanghae.delivery99.service;



import com.hanghae.delivery99.dto.RestaurantDto;
import com.hanghae.delivery99.model.Restaurant;
import com.hanghae.delivery99.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Restaurant registRestaurants(RestaurantDto restaurantDto){
        int minCheck = restaurantDto.getMinOrderPrice();
        int feeCheck = restaurantDto.getDeliveryFee();

        Restaurant restaurant = new Restaurant(restaurantDto);

        if (minCheck < 1000 || minCheck > 100000){
            throw new NullPointerException("1,000원 이상 100,000원 이하로 입력해주세요.");
        }else if (minCheck%100 != 0){
            throw new NullPointerException("100원 단위로 입력해주세요.");
        } else if (feeCheck < 0 || feeCheck > 10000) {
            throw new NullPointerException("0원 이상 10,000원 이하로 입력해주세요.");
        } else if (feeCheck%500 != 0) {
            throw new NullPointerException("500원 단위로 입력해주세요.");
        }
        return restaurantRepository.save(restaurant);    }

}
