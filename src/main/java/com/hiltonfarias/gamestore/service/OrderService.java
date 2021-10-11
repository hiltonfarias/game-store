package com.hiltonfarias.gamestore.service;

import com.hiltonfarias.gamestore.entity.Checkout;
import com.hiltonfarias.gamestore.entity.Order;
import com.hiltonfarias.gamestore.entity.Product;
import com.hiltonfarias.gamestore.repository.OrderRepository;
import com.hiltonfarias.gamestore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    public Long createOrderCart() {
        return new Order().getId();
    }

    public void addProduct(Long idOrder, Long idProduct) {
        Optional<Order> orderFound = orderRepository.findById(idOrder);
        if (orderFound.isPresent()) {
            orderFound.get().addItem(productRepository.getById(idProduct));
            orderRepository.save(orderFound.get());
        }
        throw new RuntimeException("not found orderId" + idOrder);
    }

    public void removeProduct(Long idOrder, Long idProduct) {

        Optional<Order> orderFound = orderRepository.findById(idOrder);
        if (orderFound.isPresent()) {
            orderFound.get().removeItem(productRepository.getById(idProduct));
            orderRepository.delete(orderFound.get());
        }
        throw new RuntimeException("not found orderId" + idOrder);

    }

    public Checkout getCheckout(Long idOrder) {
        Optional<Order> orderFound = orderRepository.findById(idOrder);
        if (orderFound.isPresent()) {
            return new Checkout(orderFound.get());
        }
        throw new RuntimeException("not found orderId" + idOrder);
    }

}
