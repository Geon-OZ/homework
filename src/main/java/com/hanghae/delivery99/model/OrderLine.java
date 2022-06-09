package com.hanghae.delivery99.model;


import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Setter
@Builder
@AllArgsConstructor
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    private Food food;

    @ManyToOne
    private Order order;

    private String name;
    private int price;


}
