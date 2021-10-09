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
public class Checkout extends Base {

    private static final long serialVersionUID = 1L;

    private final BigDecimal MAX_FEE = new BigDecimal(250.0);

    private BigDecimal fee;

    private BigDecimal total;

    private List<Product> products;

    public Checkout(BigDecimal amountFee, BigDecimal subTotal, Product products) {
        if ( subTotal.equals(this.MAX_FEE) ) {
            this.fee = new BigDecimal(0);
            this.total = subTotal;
        } else {
            this.fee = new BigDecimal(String.valueOf(amountFee));
            this.total = new BigDecimal(String.valueOf(subTotal)).add(this.fee);
        }
        this.products.add(products);
    }
}
