package com.hanghae.delivery99.model;

import com.hanghae.delivery99.dto.FoodDto;
import com.hanghae.delivery99.dto.RestaurantDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Long restaurantId;




    public Food (Long id, FoodDto foodDto){
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurantId = id;
    }
}
