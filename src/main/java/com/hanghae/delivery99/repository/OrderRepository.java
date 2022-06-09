package com.hanghae.delivery99.repository;

import com.hanghae.delivery99.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
