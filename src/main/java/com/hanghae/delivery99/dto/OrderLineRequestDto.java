package com.hanghae.delivery99.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderLineRequestDto {

    private final Long id;
    private final int quantity;
}
