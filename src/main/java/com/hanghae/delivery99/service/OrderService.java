package com.hanghae.delivery99.service;


import com.hanghae.delivery99.dto.OrderDto;
import com.hanghae.delivery99.dto.OrderLineDto;
import com.hanghae.delivery99.dto.OrderRequestDto;
import com.hanghae.delivery99.model.Food;
import com.hanghae.delivery99.model.Order;
import com.hanghae.delivery99.model.OrderLine;
import com.hanghae.delivery99.model.Restaurant;
import com.hanghae.delivery99.repository.FoodRepository;
import com.hanghae.delivery99.repository.OrderLineRepository;
import com.hanghae.delivery99.repository.OrderRepository;
import com.hanghae.delivery99.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final FoodRepository foodRepository;
    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderLineRepository orderLineRepository;

    @Transactional
    public OrderDto registOrders(OrderRequestDto orderRequestDto){

        Restaurant restaurant = getRestaurant(orderRequestDto);

        int totalPrice = 0;
        List<OrderLineDto> orderLineDtoList = new ArrayList<>();
        List<OrderLine> orderFood = orderRequestDto.getFoods();
        List<OrderLine> orderFoodList = new ArrayList<>();

        for (OrderLine tempOrderLine : orderFood){
            int quantity = tempOrderLine.getQuantity();
            if (quantity<1 || quantity>100){throw new RuntimeException("1이상 100이하만 가능합니다.");}

            Food food = getFood(tempOrderLine);

            OrderLine orderLine = OrderLine.builder()
                    .quantity(tempOrderLine.getQuantity())
                    .name(food.getName())
                    .price(food.getPrice() * quantity)
                    .food(food)
                    .build();
            orderLineRepository.save(orderLine);
            OrderLineDto orderLineDto = new OrderLineDto(orderLine);
            orderLineDtoList.add(orderLineDto);
            totalPrice += food.getPrice() * quantity;
            orderFoodList.add(orderLine);
        }

        if (totalPrice<restaurant.getMinOrderPrice()){
            throw new RuntimeException("최소 주문 금액이 모자랍니다.");
        }
        int deliveryFee = restaurant.getDeliveryFee();

        totalPrice+=deliveryFee;
        Order order = Order.builder()
                .restaurantName(restaurant.getName())
                .totalPrice(totalPrice)
                .foods(orderFoodList)
                .build();

        orderRepository.save(order);
        OrderDto orderDto = new OrderDto(order, deliveryFee, orderLineDtoList);
        return orderDto;
    }

    private Restaurant getRestaurant(OrderRequestDto orderRequestDto){
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                ()-> new NullPointerException("음식점을 찾을 수 없습니다.")
        );
        return restaurant;
    }
    private Food getFood(OrderLine tempOrderList){
        return foodRepository.findById(tempOrderList.getId()).orElseThrow(
                ()-> new NullPointerException("음식을 찾을 수 없습니다.")
        );
    }
    @Transactional
    public List<OrderDto> findAllOrder(){
        List<OrderDto> orderDtoList = new ArrayList<>();

        List<Order> orderList= orderRepository.findAll();
        for(Order order : orderList) {
            int deliveryFee = restaurantRepository.findByName(order.getRestaurantName()).getDeliveryFee();
            List<OrderLineDto> orderLineDtoList = new ArrayList<>();
            List<OrderLine> orderFoodList = orderLineRepository.findAll();
            for (OrderLine orderLine : orderFoodList){
                OrderLineDto orderLineDto = new OrderLineDto(orderLine);
                orderLineDtoList.add(orderLineDto);
            }
            OrderDto orderDto = new OrderDto(order,deliveryFee,orderLineDtoList);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

}
