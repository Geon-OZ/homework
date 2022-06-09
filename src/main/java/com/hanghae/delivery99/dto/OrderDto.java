package com.hanghae.delivery99.dto;

import com.hanghae.delivery99.model.Order;
import com.hanghae.delivery99.model.OrderLine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private String restaurantName;
    private List<OrderLineDto> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderDto(Order order, int deliveryFee, List<OrderLineDto>orderLineDtoList){
        this.restaurantName = order.getRestaurantName();
        this.foods = orderLineDtoList;
        this.deliveryFee = deliveryFee;
        this.totalPrice = order.getTotalPrice();
    }
}
