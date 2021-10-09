package com.hiltonfarias.gamestore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Product extends Base {

    private static final long serialVersionUID = 1L;

    public String name;

    public BigDecimal price;

    public short score;

    public String image;
}
