package com.hiltonfarias.gamestore.repository;

import com.hiltonfarias.gamestore.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout,Long> {

}
