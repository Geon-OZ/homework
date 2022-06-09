package com.hanghae.delivery99.controller;

import com.hanghae.delivery99.dto.OrderDto;
import com.hanghae.delivery99.dto.OrderRequestDto;
import com.hanghae.delivery99.repository.OrderRepository;
import com.hanghae.delivery99.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @PostMapping("/order/request")
    private OrderDto registOrders(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.registOrders(orderRequestDto);
    }

    @GetMapping("/orders")
    public List<OrderDto> findAllOrder(){
        return orderService.findAllOrder();
    }

}
