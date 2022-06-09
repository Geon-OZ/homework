package com.hanghae.delivery99.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RestaurantDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
