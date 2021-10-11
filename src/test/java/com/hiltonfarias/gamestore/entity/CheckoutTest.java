package com.hiltonfarias.gamestore.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckoutTest {

    @Test
    @DisplayName("Testa se uma compra com valor inferior a 250 é cobrada frete")
    public void shouldContainFee() {

        Product product = new Product(1L,"P1", new BigDecimal("100.0"), (short) 1, "test");
        Order order = new Order();
        order.addItem(product);

        Checkout checkout = new Checkout(order);
        assertTrue(checkout.getFee().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("Testa se uma compra não é cobrada frete")
    public void shouldNotContainFee() {

        Product product = new Product(1L, "P1", new BigDecimal("251.0"), (short) 1, "test");
        Order order = new Order();
        order.addItem(product);

        Checkout checkout = new Checkout(order);
        assertEquals(0, checkout.getFee().compareTo(BigDecimal.ZERO));

    }

    @Test
    @DisplayName("Testa Calculo do valor total")
    public void shouldCalculateTotal() {

        Product product = new Product(1L,"P1", new BigDecimal("200.0"), (short) 1, "test");
        Product product2 = new Product(2L,"P2", new BigDecimal("20.0"), (short) 1, "test");
        Order order = new Order();
        order.addItem(product);
        order.addItem(product2);

        Checkout checkout = new Checkout(order);
        BigDecimal total = checkout.getSubTotal().add(checkout.getFee());
        assertEquals(checkout.getFee(), new BigDecimal("20"));
        assertEquals(0, total.compareTo(new BigDecimal("240.0")));
    }

    @Test
    @DisplayName("Testa Calculo do subtotal")
    public void shouldCalculateSubTotal() {

        Product product = new Product(1L,"P1", new BigDecimal("200.0"), (short) 1, "test");
        Product product2 = new Product(2L,"P2", new BigDecimal("20.0"), (short) 1, "test");
        Order order = new Order();
        order.addItem(product);
        order.addItem(product2);

        Checkout checkout = new Checkout(order);
        assertEquals(0, checkout.getSubTotal().compareTo(new BigDecimal("220.0")));
    }
}