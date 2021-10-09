package com.hiltonfarias.gamestore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Order extends Base {

    private static final long serialVersionUID = 1L;

    private BigDecimal amountFee;

    private BigDecimal subTotal;

    private List<Product> products;

    public void addItem(Product product) {
        this.amountFee = new BigDecimal(10.0).add(amountFee);
        this.subTotal = new BigDecimal(String.valueOf(this.subTotal)).add(product.price);
        this.products.add(product);
    }

    public void removeItem(Product product) {
        this.amountFee = new BigDecimal(String.valueOf(amountFee)).subtract(new BigDecimal(10));
        this.subTotal = new BigDecimal(String.valueOf(this.subTotal)).subtract(product.price);
        this.products.remove(product.id);
    }
}
