package com.hanghae.delivery99.repository;

import com.hanghae.delivery99.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    List<OrderLine> findAllByOrderId(Long id);
}
