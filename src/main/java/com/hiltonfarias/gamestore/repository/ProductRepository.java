package com.hiltonfarias.gamestore.repository;

import com.hiltonfarias.gamestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
