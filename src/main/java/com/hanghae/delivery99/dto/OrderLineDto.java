package com.hanghae.delivery99.dto;

import com.hanghae.delivery99.model.OrderLine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderLineDto {
    private String name;
    private int quantity;
    private int price;

    public OrderLineDto(OrderLine orderLine){
        this.name=orderLine.getName();
        this.quantity= orderLine.getQuantity();
        this.price=orderLine.getPrice();
    }
}
