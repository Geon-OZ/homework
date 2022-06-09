package com.hanghae.delivery99.dto;

import com.hanghae.delivery99.model.OrderLine;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class OrderRequestDto {
    private final Long restaurantId;
    private final List<OrderLine> foods;
}
