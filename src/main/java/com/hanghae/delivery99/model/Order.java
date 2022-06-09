package com.hanghae.delivery99.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private int totalPrice;

    @OneToMany
    private List<OrderLine> foods;


}
