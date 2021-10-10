package com.hiltonfarias.gamestore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@Entity
public class Checkout extends Base {

    private static final long serialVersionUID = 1L;

    private final BigDecimal MAX_FEE = new BigDecimal("250.0");

    private BigDecimal fee;

    private BigDecimal subTotal;

    @OneToMany(cascade = { CascadeType.MERGE})
    private List<Product> products = new ArrayList<>();

    public Checkout(Order order) {
        if ( order.getSubTotal().compareTo(this.MAX_FEE) >= 0 ) {
            this.fee = BigDecimal.ZERO;
        } else {
            this.fee = order.getAmountFee();
        }
        this.subTotal = order.getSubTotal();
        this.products.addAll(order.getProducts());
    }
}
