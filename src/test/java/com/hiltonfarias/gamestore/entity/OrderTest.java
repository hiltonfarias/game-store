package com.hiltonfarias.gamestore.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void shouldADDItem() {

        Product product = new Product(1L,"P1", new BigDecimal("10.0"), (short) 1, "test");
        Order order = new Order();
        order.addItem(product);

        assertTrue(order.getProducts().contains(product));
    }

    @Test
    public void shouldRemoveItem() {

        Product product = new Product(1L,"P1", new BigDecimal("10.0"), (short) 1, "test");
        Order order = new Order();
        order.addItem(product);
        order.removeItem(product);

        assertFalse(order.getProducts().contains(product));
    }
}