package com.hiltonfarias.gamestore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@Getter
@Setter
//@EqualsAndHashCode(callSuper = false)
@Entity
public class Order extends Base {

    private static final long serialVersionUID = 1L;

    private static final BigDecimal FEE = new BigDecimal(10);

    private BigDecimal amountFee = BigDecimal.ZERO;

    private BigDecimal subTotal = BigDecimal.ZERO;

    @OneToMany(cascade = { CascadeType.MERGE})
    private List<Product> products = new ArrayList<>();

    public void addItem(Product product) {
        this.amountFee = this.amountFee.add(FEE);
        this.subTotal = this.subTotal.add(product.price);
        this.products.add(product);
    }

    public void removeItem(Product product) {
        this.amountFee = this.amountFee.subtract(FEE);
        this.subTotal = this.subTotal.subtract(product.price);
        this.products.remove(product.id);
    }
}
