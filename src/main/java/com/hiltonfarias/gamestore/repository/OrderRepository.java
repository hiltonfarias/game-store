package com.hiltonfarias.gamestore.repository;

import com.hiltonfarias.gamestore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
