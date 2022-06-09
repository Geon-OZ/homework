package com.hanghae.delivery99.repository;


import com.hanghae.delivery99.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findAll();
    Restaurant findByName(String name);
}
