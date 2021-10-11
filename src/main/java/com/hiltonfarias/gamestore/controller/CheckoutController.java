package com.hiltonfarias.gamestore.controller;

import com.hiltonfarias.gamestore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/")
    public OrderService getCheckoutService() {
        Long orderCart = orderService.createOrderCart();
        return orderService;
    }
}
